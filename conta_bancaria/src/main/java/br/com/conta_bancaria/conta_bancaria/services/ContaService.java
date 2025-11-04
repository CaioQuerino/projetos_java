package br.com.conta_bancaria.conta_bancaria.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.conta_bancaria.conta_bancaria.models.*;
import br.com.conta_bancaria.conta_bancaria.repository.*;

import java.util.*;

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
    public Conta criarConta(Conta conta) {
        // gerar número e agência
        String numeroConta = gerarNumeroConta();
        String agencia = gerarNumeroAgencia();

        conta.getCliente().setAgencia(agencia);
        conta.getBanco().setAgencia(agencia);

        repositoryCliente.save(conta.getCliente());
        repositoryBanco.save(conta.getBanco());

        conta.setNumeroConta(numeroConta);
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