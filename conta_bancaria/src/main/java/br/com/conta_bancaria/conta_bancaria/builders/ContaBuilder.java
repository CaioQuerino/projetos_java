package br.com.conta_bancaria.conta_bancaria.builders;

import br.com.conta_bancaria.conta_bancaria.models.Cliente;
import br.com.conta_bancaria.conta_bancaria.models.Banco;
import br.com.conta_bancaria.conta_bancaria.models.Conta;

public class ContaBuilder {

    private String numeroConta;
    private String tipoConta;
    private Double saldo;
    private Cliente cliente;
    private Banco banco;
    private String senha;

    public ContaBuilder numeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
        return this;
    }

    public ContaBuilder tipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
        return this;
    }

    public ContaBuilder saldo(Double saldo) {
        this.saldo = saldo;
        return this;
    }

    public ContaBuilder cliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public ContaBuilder banco(Banco banco) {
        this.banco = banco;
        return this;
    }

    public ContaBuilder senha(String senha) {
        this.senha = senha;
        return this;
    }

    public Conta build() {
        Conta conta = new Conta();
        conta.setNumeroConta(this.numeroConta);
        conta.setTipoConta(this.tipoConta);
        conta.setSaldo(this.saldo);
        conta.setCliente(this.cliente);
        conta.setBanco(this.banco);
        conta.setSenha(this.senha);
        return conta;
    }
}
