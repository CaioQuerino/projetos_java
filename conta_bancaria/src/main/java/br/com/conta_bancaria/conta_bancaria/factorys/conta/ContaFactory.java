package br.com.conta_bancaria.conta_bancaria.factorys.conta;

import br.com.conta_bancaria.conta_bancaria.models.*;
import br.com.conta_bancaria.conta_bancaria.interfaces.ContaRequest;

/**
 * Factory responsável por criar instâncias de Conta a partir dos DTOs de request.
 */
public class ContaFactory {

    private static Conta from(ContaRequest request, Cliente cliente, Banco banco) {
        return Conta.builder()
            .tipoConta(request.getTipoConta())
            .saldo(request.getSaldo())
            .cliente(cliente)
            .banco(banco)
            .senha(request.getSenha())
            .build();
    }

    public static Conta fromRequest(Object request, Cliente cliente, Banco banco) {
        return request instanceof ContaRequest
            ? from((ContaRequest) request, cliente, banco)
            : null;
    }
}