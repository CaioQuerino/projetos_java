package br.com.conta_bancaria.conta_bancaria.factorys.conta;

import br.com.conta_bancaria.conta_bancaria.builders.ContaBuilder;
import br.com.conta_bancaria.conta_bancaria.dto.requests.conta.*;
import br.com.conta_bancaria.conta_bancaria.models.*;

/**
 * Factory responsável por criar instâncias de Conta a partir dos DTOs de request.
 */
public class ContaFactory {

    public static Conta fromCreate(CreateContaRequest request, Cliente cliente, Banco banco) {
        return new ContaBuilder()
            .tipoConta(request.getTipoConta())
            .saldo(request.getSaldo())
            .cliente(cliente)
            .banco(banco)
            .senha(request.getSenha())
            .build();
    }

    public static Conta fromUpdate(UpdateContaRequest request, Cliente cliente, Banco banco) {
        return new ContaBuilder()
            .tipoConta(request.getTipoConta())
            .saldo(request.getSaldo())
            .cliente(cliente)
            .banco(banco)
            .senha(request.getSenha())
            .build();
    }
}