package br.com.conta_bancaria.conta_bancaria.interfaces;

public interface ContaRequest {
    String getTipoConta();
    double getSaldo();
    Long getClienteId();
    Long getBancoId();
    String getSenha();
}