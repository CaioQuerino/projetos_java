package br.com.conta_bancaria.conta_bancaria.dto.requests.login;

public class LoginRequest {
    private String numeroConta;
    private String senha;

    public LoginRequest() {}

    public LoginRequest(String numeroConta, String senha) {
        this.numeroConta = numeroConta;
        this.senha = senha;
    }

    public String getNumeroConta() { return numeroConta; }

    public void setNumeroConta(String numeroConta) { this.numeroConta = numeroConta; }

    public String getSenha() { return senha; }
    
    public void setSenha(String senha) { this.senha = senha; }
}