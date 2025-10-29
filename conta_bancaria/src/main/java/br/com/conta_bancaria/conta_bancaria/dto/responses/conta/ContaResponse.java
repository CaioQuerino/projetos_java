package br.com.conta_bancaria.conta_bancaria.dto.responses.conta;

public class ContaResponse {
    private String agencia;
    private String numeroConta;
    private String tipoConta;
    private double saldo;
    private String nomeCliente;
    private String nomeBanco;
    

    public ContaResponse(String agencia, String numeroConta, String tipoConta, 
                            double saldo, String nomeCliente, String nomeBanco) 
    {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.nomeCliente = nomeCliente;
        this.nomeBanco = nomeBanco;
    }

    public String getAgencia() { return agencia; }

    public String getNumeroConta() { return numeroConta; }

    public String getTipoConta() { return tipoConta; }

    public double getSaldo() { return saldo; }

    public String getNomeCliente() { return nomeCliente; }

    public String getNomeBanco() { return nomeBanco; }
}