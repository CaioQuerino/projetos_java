package br.com.conta_bancaria.conta_bancaria.dto.responses.login;

import br.com.conta_bancaria.conta_bancaria.dto.responses.conta.ContaResponse;

public class LoginResponse {
    private boolean success;
    private String message;
    private ContaResponse conta;
    private String token;

    public LoginResponse() {}

    public LoginResponse(boolean success, String message, ContaResponse conta, String token) {
        this.success = success;
        this.message = message;
        this.conta = conta;
        this.token = token;
    }

    public LoginResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() { return success; }

    public void setSuccess(boolean success) { this.success = success; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public ContaResponse getConta() { return conta; }

    public void setConta(ContaResponse conta) { this.conta = conta; }

    public String getToken() { return token; }
    
    public void setToken(String token) { this.token = token; }
}