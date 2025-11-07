package br.com.conta_bancaria.conta_bancaria.factorys.banco;

import br.com.conta_bancaria.conta_bancaria.interfaces.BancoRequest;
import br.com.conta_bancaria.conta_bancaria.models.Banco;

public class BancoFactory {

    private static Banco from(BancoRequest request) {
        return Banco.builder()
            .nome(request.getNome())
            .endereco(request.getEndereco())
            .telefone(request.getTelefone())
            .cnpj(request.getCnpj())
            .agencia(request.getAgencia())
            .codigoBanco(request.getCodigoBanco())
            .build();
    }

    public static Banco fromRequest(Object request) {
        return request instanceof BancoRequest
            ? from((BancoRequest) request)
            : null;
    }
}