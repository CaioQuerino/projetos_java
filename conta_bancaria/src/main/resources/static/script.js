const API_BASE_URL = 'http://localhost:8080';

// Sistema de Tabs
function openTab(tabName) {
    document.querySelectorAll('.tab-content').forEach(tab => {
        tab.classList.remove('active');
    });
    
    document.querySelectorAll('.tab-button').forEach(button => {
        button.classList.remove('active');
    });
    
    document.getElementById(tabName).classList.add('active');
    event.currentTarget.classList.add('active');
    
    // Salvar tab ativa
    localStorage.setItem('activeTab', tabName);
}

// Notificações
function showNotification(message, type = 'info') {
    const notification = document.getElementById('notification');
    notification.textContent = message;
    notification.className = `notification ${type} show`;
    
    setTimeout(() => {
        notification.classList.remove('show');
    }, 4000);
}

// Modal functions
function showPrivacyPolicy() {
    document.getElementById('privacyModal').style.display = 'block';
    event.preventDefault();
}

function showTerms() {
    showNotification('Termos de uso carregados', 'info');
    event.preventDefault();
}

function closeModal(modalId) {
    document.getElementById(modalId).style.display = 'none';
}

// Validação de CPF
function validarCPF(cpf) {
    const cpfLimpo = cpf.replace(/\D/g, '');
    const validationElement = document.getElementById('cpf-validation');
    
    if (cpfLimpo.length !== 11 || /^(\d)\1+$/.test(cpfLimpo)) {
        validationElement.textContent = 'CPF inválido';
        validationElement.className = 'validation-message validation-invalid';
        return false;
    }
    
    // Validação dos dígitos verificadores
    let soma = 0;
    for (let i = 0; i < 9; i++) {
        soma += parseInt(cpfLimpo.charAt(i)) * (10 - i);
    }
    
    let resto = soma % 11;
    let digito1 = resto < 2 ? 0 : 11 - resto;
    
    if (digito1 !== parseInt(cpfLimpo.charAt(9))) {
        validationElement.textContent = 'CPF inválido';
        validationElement.className = 'validation-message validation-invalid';
        return false;
    }
    
    soma = 0;
    for (let i = 0; i < 10; i++) {
        soma += parseInt(cpfLimpo.charAt(i)) * (11 - i);
    }
    
    resto = soma % 11;
    let digito2 = resto < 2 ? 0 : 11 - resto;
    
    if (digito2 !== parseInt(cpfLimpo.charAt(10))) {
        validationElement.textContent = 'CPF inválido';
        validationElement.className = 'validation-message validation-invalid';
        return false;
    }
    
    validationElement.textContent = 'CPF válido';
    validationElement.className = 'validation-message validation-valid';
    return true;
}

// Validação de CNPJ
function validarCNPJ(cnpj) {
    const cnpjLimpo = cnpj.replace(/\D/g, '');
    const validationElement = document.getElementById('cnpj-validation');
    
    if (cnpjLimpo.length !== 14 || /^(\d)\1+$/.test(cnpjLimpo)) {
        validationElement.textContent = 'CNPJ inválido';
        validationElement.className = 'validation-message validation-invalid';
        return false;
    }
    
    // Validação dos dígitos verificadores
    let tamanho = cnpjLimpo.length - 2;
    let numeros = cnpjLimpo.substring(0, tamanho);
    let digitos = cnpjLimpo.substring(tamanho);
    let soma = 0;
    let pos = tamanho - 7;
    
    for (let i = tamanho; i >= 1; i--) {
        soma += numeros.charAt(tamanho - i) * pos--;
        if (pos < 2) pos = 9;
    }
    
    let resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
    if (resultado !== parseInt(digitos.charAt(0))) {
        validationElement.textContent = 'CNPJ inválido';
        validationElement.className = 'validation-message validation-invalid';
        return false;
    }
    
    tamanho = tamanho + 1;
    numeros = cnpjLimpo.substring(0, tamanho);
    soma = 0;
    pos = tamanho - 7;
    
    for (let i = tamanho; i >= 1; i--) {
        soma += numeros.charAt(tamanho - i) * pos--;
        if (pos < 2) pos = 9;
    }
    
    resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
    if (resultado !== parseInt(digitos.charAt(1))) {
        validationElement.textContent = 'CNPJ inválido';
        validationElement.className = 'validation-message validation-invalid';
        return false;
    }
    
    validationElement.textContent = 'CNPJ válido';
    validationElement.className = 'validation-message validation-valid';
    return true;
}

// Toggle password visibility
function togglePassword(inputId) {
    const input = document.getElementById(inputId);
    const button = event.currentTarget;
    
    if (input.type === 'password') {
        input.type = 'text';
        button.textContent = '🙈';
    } else {
        input.type = 'password';
        button.textContent = '👁️';
    }
}

// Password strength indicator
function checkPasswordStrength(password) {
    const container = document.querySelector('.password-group');
    const strengthBar = document.querySelector('.strength-bar');
    const strengthText = document.querySelector('.strength-text');
    
    let strength = 0;
    
    if (password.length >= 4) strength += 1;
    if (password.length >= 6) strength += 1;
    if (/[0-9]/.test(password)) strength += 1;
    if (/[a-zA-Z]/.test(password)) strength += 1;
    
    container.classList.remove('password-weak', 'password-medium', 'password-strong');
    
    if (strength <= 2) {
        container.classList.add('password-weak');
        strengthText.textContent = 'Senha fraca';
    } else if (strength <= 3) {
        container.classList.add('password-medium');
        strengthText.textContent = 'Senha média';
    } else {
        container.classList.add('password-strong');
        strengthText.textContent = 'Senha forte';
    }
}

// Mascarar dados sensíveis
function mascararCPF(cpf) {
    if (!cpf) return 'Não informado';
    return cpf.replace(/(\d{3})\.(\d{3})\.(\d{3})-(\d{2})/, '***.***.$3-**');
}

function mascararCNPJ(cnpj) {
    if (!cnpj) return 'Não informado';
    return cnpj.replace(/(\d{2})\.(\d{3})\.(\d{3})\/(\d{4})-(\d{2})/, '**.***.***/$4-**');
}

function mascararTelefone(telefone) {
    if (!telefone) return 'Não informado';
    return telefone.replace(/(\(\d{2}\))\s(\d{4,5})-(\d{4})/, '$1 ****-$3');
}

// Buscar CEP do Cliente
async function buscarCEP() {
    const cep = document.getElementById('cep').value.replace(/\D/g, '');
    
    if (cep.length !== 8) {
        showNotification('CEP deve ter 8 dígitos', 'error');
        return;
    }
    
    try {
        showNotification('Buscando CEP...', 'info');
        
        const response = await fetch(`https://viacep.com.br/ws/${cep}/json/`);
        const data = await response.json();
        
        if (data.erro) {
            showNotification('CEP não encontrado', 'error');
            return;
        }
        
        document.getElementById('logradouro').value = data.logradouro || '';
        document.getElementById('complemento').value = data.complemento || '';
        document.getElementById('bairro').value = data.bairro || '';
        document.getElementById('localidade').value = data.localidade || '';
        document.getElementById('uf').value = data.uf || '';
        
        showNotification('CEP encontrado com sucesso!', 'success');
        
    } catch (error) {
        showNotification('Erro ao buscar CEP', 'error');
        console.error('Erro:', error);
    }
}

// Buscar CEP do Banco
async function buscarCEPBanco() {
    const cep = document.getElementById('bancoCep').value.replace(/\D/g, '');
    
    if (cep.length !== 8) {
        showNotification('CEP do banco deve ter 8 dígitos', 'error');
        return;
    }
    
    try {
        showNotification('Buscando CEP do banco...', 'info');
        
        const response = await fetch(`https://viacep.com.br/ws/${cep}/json/`);
        const data = await response.json();
        
        if (data.erro) {
            showNotification('CEP do banco não encontrado', 'error');
            return;
        }
        
        document.getElementById('bancoLogradouro').value = data.logradouro || '';
        document.getElementById('bancoComplemento').value = data.complemento || '';
        document.getElementById('bancoBairro').value = data.bairro || '';
        document.getElementById('bancoLocalidade').value = data.localidade || '';
        document.getElementById('bancoUf').value = data.uf || '';
        
        showNotification('CEP do banco encontrado com sucesso!', 'success');
        
    } catch (error) {
        showNotification('Erro ao buscar CEP do banco', 'error');
        console.error('Erro:', error);
    }
}

// Copiar endereço (opcional)
function copiarEnderecoParaBanco() {
    if (confirm('Deseja copiar o endereço do cliente para o banco?')) {
        document.getElementById('bancoCep').value = document.getElementById('cep').value;
        document.getElementById('bancoLogradouro').value = document.getElementById('logradouro').value;
        document.getElementById('bancoComplemento').value = document.getElementById('complemento').value;
        document.getElementById('bancoBairro').value = document.getElementById('bairro').value;
        document.getElementById('bancoLocalidade').value = document.getElementById('localidade').value;
        document.getElementById('bancoUf').value = document.getElementById('uf').value;
        showNotification('Endereço copiado para o banco!', 'success');
    }
}

// Criar Conta - VERSÃO CORRIGIDA E FUNCIONAL
document.getElementById('form-conta').addEventListener('submit', async function(e) {
    e.preventDefault();
    
    if (!document.getElementById('lgpd-consent').checked) {
        showNotification('É necessário concordar com a política de privacidade', 'error');
        return;
    }
    
    const formData = new FormData(this);
    const senha = formData.get('senha');
    
    if (!/^\d{4}$/.test(senha)) {
        showNotification('A senha deve conter exatamente 4 dígitos numéricos', 'error');
        return;
    }

    // Validar CPF
    if (!validarCPF(formData.get('clienteCpf'))) {
        showNotification('CPF inválido', 'error');
        return;
    }

    // Validar CNPJ
    if (!validarCNPJ(formData.get('bancoCnpj'))) {
        showNotification('CNPJ inválido', 'error');
        return;
    }

    // Preparar dados do cliente
    const clienteData = {
        nome: formData.get('clienteNome'),
        cpf: formData.get('clienteCpf'),
        telefone: formData.get('clienteTelefone'),
        codigoBanco: formData.get('clienteCodigoBanco'),
        endereco: {
            cep: formData.get('cep'),
            logradouro: formData.get('logradouro'),
            complemento: formData.get('complemento'),
            bairro: formData.get('bairro'),
            localidade: formData.get('localidade'),
            uf: formData.get('uf')
        }
    };

    // Preparar dados do banco
    const bancoData = {
        nome: formData.get('bancoNome'),
        cnpj: formData.get('bancoCnpj'),
        telefone: formData.get('bancoTelefone'),
        codigoBanco: formData.get('clienteCodigoBanco'),
        endereco: {
            cep: formData.get('bancoCep'),
            logradouro: formData.get('bancoLogradouro'),
            complemento: formData.get('bancoComplemento'),
            bairro: formData.get('bancoBairro'),
            localidade: formData.get('bancoLocalidade'),
            uf: formData.get('bancoUf')
        }
    };

    try {
        const submitBtn = this.querySelector('button[type="submit"]');
        submitBtn.innerHTML = '<span class="loading-spinner"></span> Criando conta...';
        submitBtn.disabled = true;
        
        showNotification('Criando cliente e banco...', 'info');

        // 1. Criar Cliente
        const clienteResponse = await fetch(`${API_BASE_URL}/clientes`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(clienteData)
        });

        if (!clienteResponse.ok) {
            const error = await clienteResponse.text();
            throw new Error(error || 'Erro ao criar cliente');
        }
        const clienteResult = await clienteResponse.json();
        const cliente = clienteResult.data;

        // 2. Criar Banco
        const bancoResponse = await fetch(`${API_BASE_URL}/bancos`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(bancoData)
        });

        if (!bancoResponse.ok) {
            const error = await bancoResponse.text();
            throw new Error(error || 'Erro ao criar banco');
        }
        const bancoResult = await bancoResponse.json();
        const banco = bancoResult.data;

        // 3. Criar Conta com os IDs
        const contaRequest = {
            tipoConta: formData.get('tipoConta'),
            saldo: parseFloat(formData.get('saldo')) || 0,
            clienteId: cliente.id,
            bancoId: banco.id,
            senha: senha
        };

        showNotification('Criando conta bancária...', 'info');

        const contaResponse = await fetch(`${API_BASE_URL}/contas`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(contaRequest)
        });

        if (!contaResponse.ok) {
            const errorText = await contaResponse.text();
            throw new Error(errorText || 'Erro ao criar conta');
        }
        
        const contaResult = await contaResponse.json();
        const contaCriada = contaResult.data;
        
        showNotification(`🎉 Conta criada com sucesso! Número: ${contaCriada.numeroConta}`, 'success');
        
        setTimeout(() => {
            alert(`✅ CONTA BANCÁRIA CRIADA!\n\n` +
                  `📋 Número da Conta: ${contaCriada.numeroConta}\n` +
                  `🏦 Agência: ${contaCriada.agencia}\n` +
                  `👤 Titular: ${cliente.nome}\n` +
                  `💰 Saldo Inicial: R$ ${contaCriada.saldo.toFixed(2)}\n` +
                  `📊 Tipo: ${contaCriada.tipoConta}\n` +
                  `🔒 Dados protegidos conforme LGPD\n\n` +
                  `Guarde estas informações em local seguro!`);
        }, 1000);
        
        this.reset();
        
    } catch (error) {
        showNotification('Erro ao criar conta: ' + error.message, 'error');
        console.error('Erro:', error);
    } finally {
        const submitBtn = document.querySelector('button[type="submit"]');
        submitBtn.innerHTML = '🎉 Criar Minha Conta Bancária';
        submitBtn.disabled = false;
    }
});

// Buscar Conta
async function buscarConta() {
    const numeroConta = document.getElementById('numeroBusca').value.trim();
    
    if (!numeroConta || !/^\d{6}$/.test(numeroConta)) {
        showNotification('Digite um número de conta válido (6 dígitos)', 'error');
        return;
    }
    
    try {
        showNotification('Buscando conta...', 'info');
        
        const response = await fetch(`${API_BASE_URL}/contas/${numeroConta}`);
        
        if (!response.ok) {
            throw new Error('Conta não encontrada');
        }
        
        const resultado = await response.json();
        const conta = resultado.data;
        
        const resultadoDiv = document.getElementById('resultado-busca');
        resultadoDiv.innerHTML = `
            <div class="conta-info">
                <div class="info-item">
                    <strong>Número da Conta:</strong> ${conta.numeroConta}
                </div>
                <div class="info-item">
                    <strong>Tipo:</strong> ${conta.tipoConta}
                </div>
                <div class="info-item">
                    <strong>Saldo:</strong> R$ ${conta.saldo.toFixed(2)}
                </div>
                <div class="info-item">
                    <strong>Agência:</strong> ${conta.agencia}
                </div>
                <div class="info-item">
                    <strong>Cliente:</strong> ${conta.nomeCliente}
                </div>
                <div class="info-item">
                    <strong>Banco:</strong> ${conta.nomeBanco}
                </div>
            </div>
        `;
        
        showNotification('Conta encontrada com sucesso!', 'success');
        
    } catch (error) {
        document.getElementById('resultado-busca').innerHTML = `
            <div style="text-align: center; color: #e74c3c; padding: 20px;">
                ${error.message}
            </div>
        `;
        showNotification(error.message, 'error');
    }
}

// Listar Contas
async function listarContas() {
    try {
        showNotification('Carregando contas...', 'info');
        
        const response = await fetch(`${API_BASE_URL}/contas`);
        
        if (!response.ok) {
            throw new Error('Erro ao carregar contas');
        }
        
        const resultado = await response.json();
        const contas = resultado.data;
        
        const listaDiv = document.getElementById('lista-contas');
        
        if (contas.length === 0) {
            listaDiv.innerHTML = '<div class="loading">Nenhuma conta cadastrada</div>';
            showNotification('Nenhuma conta encontrada', 'info');
            return;
        }
        
        listaDiv.innerHTML = `
            <table>
                <thead>
                    <tr>
                        <th>Número</th>
                        <th>Tipo</th>
                        <th>Saldo</th>
                        <th>Cliente</th>
                        <th>Banco</th>
                        <th>Agência</th>
                    </tr>
                </thead>
                <tbody>
                    ${contas.map(conta => `
                        <tr>
                            <td><strong>${conta.numeroConta}</strong></td>
                            <td>${conta.tipoConta}</td>
                            <td style="color: ${conta.saldo >= 0 ? '#27ae60' : '#e74c3c'}; font-weight: bold;">
                                R$ ${conta.saldo.toFixed(2)}
                            </td>
                            <td>${conta.nomeCliente}</td>
                            <td>${conta.nomeBanco}</td>
                            <td>${conta.agencia}</td>
                        </tr>
                    `).join('')}
                </tbody>
            </table>
            
            <div style="margin-top: 20px; padding: 15px; background: #f8f9fa; border-radius: 8px; text-align: center;">
                <strong>Total de contas:</strong> ${contas.length} | 
                <strong>Saldo total:</strong> R$ ${contas.reduce((total, conta) => total + conta.saldo, 0).toFixed(2)}
            </div>
        `;
        
        showNotification(`${contas.length} contas carregadas com segurança!`, 'success');
        
    } catch (error) {
        document.getElementById('lista-contas').innerHTML = `
            <div style="text-align: center; color: #e74c3c; padding: 20px;">
                ❌ Erro ao carregar contas: ${error.message}
            </div>
        `;
        showNotification('Erro ao carregar contas: ' + error.message, 'error');
        console.error('Erro:', error);
    }
}

// Listar Clientes
async function listarClientes() {
    try {
        showNotification('Carregando clientes...', 'info');
        
        const response = await fetch(`${API_BASE_URL}/clientes`);
        
        if (!response.ok) {
            throw new Error('Erro ao carregar clientes');
        }
        
        const resultado = await response.json();
        const clientes = resultado.data;
        
        const listaDiv = document.getElementById('lista-clientes');
        
        if (clientes.length === 0) {
            listaDiv.innerHTML = '<div class="loading">Nenhum cliente cadastrado</div>';
            showNotification('Nenhum cliente encontrado', 'info');
            return;
        }
        
        listaDiv.innerHTML = `
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Telefone</th>
                        <th>Agência</th>
                        <th>Código Banco</th>
                    </tr>
                </thead>
                <tbody>
                    ${clientes.map(cliente => `
                        <tr>
                            <td>${cliente.id}</td>
                            <td>${cliente.nome}</td>
                            <td><span class="masked-data">${mascararCPF(cliente.cpf)}</span></td>
                            <td><span class="masked-data">${mascararTelefone(cliente.telefone)}</span></td>
                            <td>${cliente.agencia || 'N/A'}</td>
                            <td>${cliente.codigoBanco}</td>
                        </tr>
                    `).join('')}
                </tbody>
            </table>
            
            <div style="margin-top: 20px; padding: 15px; background: #f8f9fa; border-radius: 8px; text-align: center;">
                <strong>Total de clientes:</strong> ${clientes.length}
            </div>
        `;
        
        showNotification(`${clientes.length} clientes carregados!`, 'success');
        
    } catch (error) {
        document.getElementById('lista-clientes').innerHTML = `
            <div style="text-align: center; color: #e74c3c; padding: 20px;">
                ❌ Erro ao carregar clientes: ${error.message}
            </div>
        `;
        showNotification('Erro ao carregar clientes: ' + error.message, 'error');
    }
}

// Listar Bancos
async function listarBancos() {
    try {
        showNotification('Carregando bancos...', 'info');
        
        const response = await fetch(`${API_BASE_URL}/bancos`);
        
        if (!response.ok) {
            throw new Error('Erro ao carregar bancos');
        }
        
        const resultado = await response.json();
        const bancos = resultado.data;
        
        const listaDiv = document.getElementById('lista-bancos');
        
        if (bancos.length === 0) {
            listaDiv.innerHTML = '<div class="loading">Nenhum banco cadastrado</div>';
            showNotification('Nenhum banco encontrado', 'info');
            return;
        }
        
        listaDiv.innerHTML = `
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>CNPJ</th>
                        <th>Telefone</th>
                        <th>Agência</th>
                        <th>Código Banco</th>
                    </tr>
                </thead>
                <tbody>
                    ${bancos.map(banco => `
                        <tr>
                            <td>${banco.id}</td>
                            <td>${banco.nome}</td>
                            <td><span class="masked-data">${mascararCNPJ(banco.cnpj)}</span></td>
                            <td>${banco.telefone}</td>
                            <td>${banco.agencia || 'N/A'}</td>
                            <td>${banco.codigoBanco}</td>
                        </tr>
                    `).join('')}
                </tbody>
            </table>
            
            <div style="margin-top: 20px; padding: 15px; background: #f8f9fa; border-radius: 8px; text-align: center;">
                <strong>Total de bancos:</strong> ${bancos.length}
            </div>
        `;
        
        showNotification(`${bancos.length} bancos carregados!`, 'success');
        
    } catch (error) {
        document.getElementById('lista-bancos').innerHTML = `
            <div style="text-align: center; color: #e74c3c; padding: 20px;">
                ❌ Erro ao carregar bancos: ${error.message}
            </div>
        `;
        showNotification('Erro ao carregar bancos: ' + error.message, 'error');
    }
}

// Testar conexão com backend
async function testarConexao() {
    try {
        const response = await fetch(`${API_BASE_URL}/health`);
        const statusIndicator = document.getElementById('status-indicator');
        const statusText = document.getElementById('status-text');
        
        if (response.ok) {
            statusIndicator.className = 'status-indicator connected';
            statusText.textContent = 'Conectado ao backend';
            statusIndicator.style.color = '#27ae60';
        } else {
            throw new Error('Backend não responde');
        }
    } catch (error) {
        const statusIndicator = document.getElementById('status-indicator');
        const statusText = document.getElementById('status-text');
        statusIndicator.className = 'status-indicator disconnected';
        statusText.textContent = 'Backend offline';
        statusIndicator.style.color = '#e74c3c';
        console.error('Erro de conexão:', error);
    }
}

// Máscaras para os campos
function aplicarMascaras() {
    // Máscara para CPF
    const cpfInput = document.getElementById('clienteCpf');
    cpfInput.addEventListener('input', function(e) {
        let value = e.target.value.replace(/\D/g, '');
        if (value.length > 11) value = value.slice(0, 11);
        
        if (value.length <= 11) {
            value = value.replace(/(\d{3})(\d)/, '$1.$2')
                        .replace(/(\d{3})(\d)/, '$1.$2')
                        .replace(/(\d{3})(\d{1,2})$/, '$1-$2');
        }
        
        e.target.value = value;
    });

    // Máscara para CNPJ
    const cnpjInput = document.getElementById('bancoCnpj');
    cnpjInput.addEventListener('input', function(e) {
        let value = e.target.value.replace(/\D/g, '');
        if (value.length > 14) value = value.slice(0, 14);
        
        if (value.length <= 14) {
            value = value.replace(/(\d{2})(\d)/, '$1.$2')
                        .replace(/(\d{3})(\d)/, '$1.$2')
                        .replace(/(\d{3})(\d)/, '$1/$2')
                        .replace(/(\d{4})(\d{1,2})$/, '$1-$2');
        }
        
        e.target.value = value;
    });

    // Máscara para CEP do cliente
    const cepInput = document.getElementById('cep');
    cepInput.addEventListener('input', function(e) {
        let value = e.target.value.replace(/\D/g, '');
        if (value.length > 8) value = value.slice(0, 8);
        
        if (value.length > 5) {
            value = value.replace(/(\d{5})(\d)/, '$1-$2');
        }
        
        e.target.value = value;
    });

    // Máscara para CEP do banco
    const bancoCepInput = document.getElementById('bancoCep');
    bancoCepInput.addEventListener('input', function(e) {
        let value = e.target.value.replace(/\D/g, '');
        if (value.length > 8) value = value.slice(0, 8);
        
        if (value.length > 5) {
            value = value.replace(/(\d{5})(\d)/, '$1-$2');
        }
        
        e.target.value = value;
    });

    // Máscara para telefone
    const telefoneInputs = document.querySelectorAll('input[type="tel"]');
    telefoneInputs.forEach(input => {
        input.addEventListener('input', function(e) {
            let value = e.target.value.replace(/\D/g, '');
            if (value.length > 11) value = value.slice(0, 11);
            
            if (value.length > 10) {
                value = value.replace(/(\d{2})(\d)/, '($1) $2')
                            .replace(/(\d{5})(\d)/, '$1-$2');
            } else if (value.length > 6) {
                value = value.replace(/(\d{2})(\d)/, '($1) $2')
                            .replace(/(\d{4})(\d)/, '$1-$2');
            } else if (value.length > 2) {
                value = value.replace(/(\d{2})(\d)/, '($1) $2');
            } else if (value.length > 0) {
                value = value.replace(/(\d{2})/, '($1');
            }
            
            e.target.value = value;
        });
    });

    // Monitorar força da senha
    const senhaInput = document.getElementById('senha');
    senhaInput.addEventListener('input', function(e) {
        checkPasswordStrength(e.target.value);
    });
}

// Inicializar quando a página carregar
document.addEventListener('DOMContentLoaded', function() {
    aplicarMascaras();
    testarConexao();
    
    // Restaurar tab ativa
    const activeTab = localStorage.getItem('activeTab') || 'criar-conta';
    document.querySelector(`[onclick="openTab('${activeTab}')"]`).click();
    
    showNotification('Sistema bancário seguro carregado! 🔒', 'success');
    
    // Fechar modal ao clicar fora
    window.onclick = function(event) {
        const modal = document.getElementById('privacyModal');
        if (event.target === modal) {
            modal.style.display = 'none';
        }
    }
    
    // Atualizar status a cada 30 segundos
    setInterval(testarConexao, 30000);
});