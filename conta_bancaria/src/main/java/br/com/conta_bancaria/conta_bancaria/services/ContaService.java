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
import java.util.Random;

@Service
public class ContaService {

    private final RepositoryConta repositoryConta;
    private final RepositoryBanco repositoryBanco;
    private final RepositoryCliente repositoryCliente;
    private final Random random = new Random();

    public ContaService(RepositoryConta repositoryConta, 
                       RepositoryBanco repositoryBanco,
                       RepositoryCliente repositoryCliente
    ) {
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
     * @param cliente
     * @param banco
     * @param senha
     * @return 
     */
    @Transactional
    public Conta criarConta(String tipoConta, double saldoInicial,
                            Cliente cliente, Banco banco, String senha) {
        if (cliente == null || banco == null) {
            throw new IllegalArgumentException("Cliente e Banco são obrigatórios para criar uma conta.");
        }

        String numeroConta = gerarNumeroConta();
        String agencia = gerarNumeroAgencia();

        Banco bancoSalvo = repositoryBanco.save(banco);
        
        cliente.setAgencia(agencia); 
        banco.setAgencia(agencia);
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
}