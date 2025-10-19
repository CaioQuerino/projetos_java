package br.com.conta_bancaria.conta_bancaria.services;

import org.springframework.stereotype.Service;

import br.com.conta_bancaria.conta_bancaria.models.Conta;
import br.com.conta_bancaria.conta_bancaria.models.Banco;
import br.com.conta_bancaria.conta_bancaria.models.Cliente;
import br.com.conta_bancaria.conta_bancaria.repository.RepositoryConta;


@Service
public class ContaService {

    private final RepositoryConta repositoryConta;

    public ContaService(RepositoryConta repositoryConta) {
        this.repositoryConta = repositoryConta;
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
    public Conta criarConta(String numeroConta, String tipoConta, double saldoInicial,
                            Cliente cliente, Banco banco, String senha) {
        if (cliente == null || banco == null) {
            throw new IllegalArgumentException("Cliente e Banco são obrigatórios para criar uma conta.");
        }

        Conta conta = new Conta(numeroConta, tipoConta, saldoInicial, cliente, banco, senha);
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
}
