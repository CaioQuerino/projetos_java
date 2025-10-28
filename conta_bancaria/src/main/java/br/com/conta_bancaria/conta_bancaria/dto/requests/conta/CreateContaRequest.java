package br.com.conta_bancaria.conta_bancaria.dto.requests.conta;


public class CreateContaRequest {
    private String tipoConta;
    private double saldo;
    private Long clienteId;
    private Long bancoId;
    private String senha;
    
    public CreateContaRequest() {}

    public CreateContaRequest(String tipoConta, double saldo, Long clienteId, 
                                                Long bancoId, String senha) 
    {
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.clienteId = clienteId;
        this.bancoId = bancoId;
        this.senha = senha;
    }

    public String getTipoConta() { return tipoConta; }

    public void setTipoConta(String tipoConta) { this.tipoConta = tipoConta; }

    public double getSaldo() { return saldo; }

    public void setSaldo(double saldo) { this.saldo = saldo; }

    public Long getClienteId() { return clienteId; }

    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public Long getBancoId() { return bancoId; }

    public void setBancoId(Long bancoId) { this.bancoId = bancoId; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

    

}
