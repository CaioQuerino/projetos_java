package br.com.conta_bancaria.conta_bancaria.dto.requests.conta;

import br.com.conta_bancaria.conta_bancaria.models.Banco;
import br.com.conta_bancaria.conta_bancaria.models.Cliente;

public class CreateContaRequest {
    private String numeroConta;
    private String tipoConta;
    private double saldo;
    private Cliente cliente;
    private Banco banco;
    private String senha;
    
    public CreateContaRequest() {}

    public CreateContaRequest(String numeroConta, String tipoConta, 
                              double saldo, Cliente cliente, Banco banco, String senha) {
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.cliente = cliente;
        this.banco = banco;
        this.senha = senha;
    }

    public String getNumeroConta() { return numeroConta; }
    public void setNumeroConta(String numeroConta) { this.numeroConta = numeroConta; }

    public String getTipoConta() { return tipoConta; }

    public void setTipoConta(String tipoConta) { this.tipoConta = tipoConta; }

    public double getSaldo() { return saldo; }

    public void setSaldo(double saldo) { this.saldo = saldo; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Banco getBanco() { return banco; }
    public void setBanco(Banco banco) { this.banco = banco; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

    

}
