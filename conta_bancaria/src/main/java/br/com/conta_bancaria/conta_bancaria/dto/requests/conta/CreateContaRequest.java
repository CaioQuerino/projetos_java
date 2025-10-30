package br.com.conta_bancaria.conta_bancaria.dto.requests.conta;

public class CreateContaRequest {
    private String tipoConta;
    private double saldo;
    private Long clienteId;
    private Long bancoId;
    private String senha;
    
    public CreateContaRequest() {}

    public CreateContaRequest(String tipoConta, double saldo, 
                                   Long clienteId, Long bancoId, String senha) {
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.clienteId = clienteId;
        this.bancoId = bancoId;
        this.senha = senha;
    }

    public String getTipoConta() { return tipoConta; }

    public double getSaldo() { return saldo; }
    
    public Long getClienteId() { return clienteId; }
        
    public Long getBancoId() { return bancoId; }
        
    public String getSenha() { return senha; }
}
