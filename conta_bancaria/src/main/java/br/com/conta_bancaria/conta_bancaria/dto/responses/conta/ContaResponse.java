package br.com.conta_bancaria.conta_bancaria.dto.responses.conta;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class ContaResponse {
    private String agencia;
    private String numeroConta;
    private String tipoConta;
    private double saldo;
    private String nomeCliente;
    private String nomeBanco;
}