package br.com.conta_bancaria.conta_bancaria.factorys.banco;

import br.com.conta_bancaria.conta_bancaria.dto.requests.banco.*;
import br.com.conta_bancaria.conta_bancaria.models.Banco;

public class BancoFactory {
    public static Banco fromCreate(CreateBancoRequest request) {
        Banco banco = Banco.builder()
            .nome(request.getNome())
            .endereco(request.getEndereco())
            .telefone(request.getTelefone())
            .cnpj(request.getCnpj())
            .agencia(request.getAgencia())
            .codigoBanco(request.getCodigoBanco())
            .build();
            return banco;
    }

    public static Banco fromUpdate(UpdateBancoRequest request) {
        Banco banco = Banco.builder()
            .nome(request.getNome())
            .endereco(request.getEndereco())
            .telefone(request.getTelefone())
            .cnpj(request.getCnpj())
            .agencia(request.getAgencia())
            .codigoBanco(request.getCodigoBanco())
            .build();
            return banco;
    }
}