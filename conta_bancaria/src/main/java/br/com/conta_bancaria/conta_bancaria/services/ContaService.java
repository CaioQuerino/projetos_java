package br.com.conta_bancaria.conta_bancaria.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.conta_bancaria.conta_bancaria.models.Conta;
import br.com.conta_bancaria.conta_bancaria.models.Banco;
import br.com.conta_bancaria.conta_bancaria.models.Cliente;
import br.com.conta_bancaria.conta_bancaria.repository.RepositoryConta;
import br.com.conta_bancaria.conta_bancaria.repository.RepositoryBanco;
import br.com.conta_bancaria.conta_bancaria.repository.RepositoryCliente;

import java.util.List;

@Service
public class ContaService {

    private final RepositoryConta repositoryConta;
    private final RepositoryBanco repositoryBanco;
    private final RepositoryCliente repositoryCliente;

    public ContaService(RepositoryConta repositoryConta, 
                       RepositoryBanco repositoryBanco,
                       RepositoryCliente repositoryCliente) {

        this.repositoryConta = repositoryConta;
        this.repositoryBanco = repositoryBanco;
        this.repositoryCliente = repositoryCliente;
    }

    /**
     * Cria uma nova conta bancária com as entidades Cliente e Banco já existentes.
     *
     * @param numeroConta número identificador da conta
     * @param tipoConta tipo da conta (ex: Corrente, Poupança)
     * @param saldoInicial valor inicial da conta
     * @param cliente objeto Cliente associado à conta
     * @param banco objeto Banco associado à conta
     * @param senha senha da conta
     * @return Conta criada e persistida no banco
     */
    @Transactional
    public Conta criarConta(String numeroConta, String tipoConta, double saldoInicial,
                            Cliente cliente, Banco banco, String senha) {
        if (cliente == null || banco == null) {
            throw new IllegalArgumentException("Cliente e Banco são obrigatórios para criar uma conta.");
        }

        Banco bancoSalvo = repositoryBanco.save(banco);
        
        Cliente clienteSalvo = repositoryCliente.save(cliente);

        Conta conta = new Conta(numeroConta, tipoConta, saldoInicial, clienteSalvo, bancoSalvo, senha);
        return repositoryConta.save(conta);
    }

    /**
     * Busca uma conta pelo número.
     * @param numeroConta
     * @return 
     */
    public Conta buscarPorNumero(String numeroConta) {
        return repositoryConta.findByNumeroConta(numeroConta)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada: " + numeroConta));
    }

    /**
     * Lista todas as contas
     * @return 
     */
    public List<Conta> listarTodas() {
        return repositoryConta.findAll();
    }

    /**
     * Busca o Banco pelo CNPJ
     * @param cnpj
     * @return 
     */
    public Banco buscarBancoPorCnpj(String cnpj) {
        return repositoryBanco.findByCnpj(cnpj);
    }

    /**
     * Busca cliente pelo CPF
     * @param cpf
     * @return 
     */
    public Cliente buscarClientePorCpf(String cpf) {
        return repositoryCliente.findByCpf(cpf);
    }

    /**
     * Lista todas os Bancos
     * @return 
     */
    public List<Banco> listarTodosBancos() {
        return repositoryBanco.findAll();
    }

    /**
     * Lista todas os Clientes
     * @return 
     */
    public List<Cliente> listarTodosClientes() {
        return repositoryCliente.findAll();
    }
}