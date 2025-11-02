package br.com.conta_bancaria.conta_bancaria.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.conta_bancaria.conta_bancaria.models.Conta;
import br.com.conta_bancaria.conta_bancaria.models.Banco;
import br.com.conta_bancaria.conta_bancaria.models.Cliente;
import br.com.conta_bancaria.conta_bancaria.repository.RepositoryConta;
import br.com.conta_bancaria.conta_bancaria.repository.RepositoryBanco;
import br.com.conta_bancaria.conta_bancaria.repository.RepositoryCliente;
import br.com.conta_bancaria.conta_bancaria.builders.ContaBuilder;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ContaService {

    private final RepositoryConta repositoryConta;
    private final RepositoryBanco repositoryBanco;
    private final RepositoryCliente repositoryCliente;
    private final Random random = new Random();

    public ContaService(RepositoryConta repositoryConta, 
                       RepositoryBanco repositoryBanco,
                       RepositoryCliente repositoryCliente) {
        this.repositoryConta = repositoryConta;
        this.repositoryBanco = repositoryBanco;
        this.repositoryCliente = repositoryCliente;
      }

    /**
     * Gera número de conta único (6 dígitos)
     */
    private String gerarNumeroConta() {
        String numeroConta;
        do {
            numeroConta = String.format("%06d", random.nextInt(1000000));
        } while (repositoryConta.findByNumeroConta(numeroConta).isPresent());
        
        return numeroConta;
    }

    /**
     * Gera número de agência (4 dígitos)
     */
    private String gerarNumeroAgencia() {
        return String.format("%04d", random.nextInt(10000));
    }

    /**
     * Cria uma nova conta bancária com números automáticos
     * @param tipoConta
     * @param saldoInicial
     * @param clienteId
     * @param bancoId
     * @param senha
     * @return 
     */
    @Transactional
    public Conta criarConta(String tipoConta, double saldoInicial,
                           Long clienteId, Long bancoId, String senha) {
        
        // Buscar cliente existente
        Cliente cliente = repositoryCliente.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + clienteId));
            
        // Buscar banco existente
        Banco banco = repositoryBanco.findById(bancoId)
                .orElseThrow(() -> new RuntimeException("Banco não encontrado com id: " + bancoId));

        String numeroConta = gerarNumeroConta();
        String agencia = gerarNumeroAgencia();

        // Atualizar agência no cliente e banco
        cliente.setAgencia(agencia);
        banco.setAgencia(agencia);

        // Salvar atualizações
        repositoryCliente.save(cliente);
        repositoryBanco.save(banco);

        // Criar e salvar conta
        Conta conta = new ContaBuilder()
            .banco(banco)
            .cliente(cliente)
            .numeroConta(numeroConta)
            .saldo(saldoInicial)
            .senha(senha)
            .tipoConta(tipoConta)
            .build();
        
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
     * Busca conta por ID
     */
    public Optional<Conta> buscarPorId(Long id) {
        return repositoryConta.findById(id);
    }
}