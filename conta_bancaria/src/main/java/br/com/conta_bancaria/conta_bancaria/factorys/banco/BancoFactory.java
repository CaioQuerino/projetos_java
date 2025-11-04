package br.com.conta_bancaria.conta_bancaria.factorys.banco;

import br.com.conta_bancaria.conta_bancaria.builders.BancoBuilder;
import br.com.conta_bancaria.conta_bancaria.dto.requests.banco.*;
import br.com.conta_bancaria.conta_bancaria.models.Banco;

public class BancoFactory {
    public static Banco fromRequest(CreateBancoRequest request) {
        return new BancoBuilder()
            .nome(request.getNome())
            .endereco(request.getEndereco())
            .telefone(request.getTelefone())
            .cnpj(request.getCnpj())
            .agencia(request.getAgencia())
            .codigoBanco(request.getCodigoBanco())
            .build();
    }

    public static Banco fromUpdate(UpdateBancoRequest request) {
        return new BancoBuilder()
            .nome(request.getNome())
            .endereco(request.getEndereco())
            .telefone(request.getTelefone())
            .cnpj(request.getCnpj())
            .agencia(request.getAgencia())
            .codigoBanco(request.getCodigoBanco())
            .build();
    }
}