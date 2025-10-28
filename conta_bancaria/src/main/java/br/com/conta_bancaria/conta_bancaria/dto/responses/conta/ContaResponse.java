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

    public void setAgencia(String agencia) { this.agencia = agencia; }

    public String getNumeroConta() { return numeroConta; }

    public void setNumeroConta(String numeroConta) { this.numeroConta = numeroConta; }

    public String getTipoConta() { return tipoConta; }

    public void setTipoConta(String tipoConta) { this.tipoConta = tipoConta; }

    public double getSaldo() { return saldo; }

    public void setSaldo(double saldo) { this.saldo = saldo; }

    public String getNomeCliente() { return nomeCliente; }

    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public String getNomeBanco() { return nomeBanco; }

    public void setNomeBanco(String nomeBanco) { this.nomeBanco = nomeBanco; }    
}