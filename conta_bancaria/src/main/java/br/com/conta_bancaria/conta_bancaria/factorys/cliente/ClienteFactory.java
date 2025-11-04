package br.com.conta_bancaria.conta_bancaria.factorys.cliente;

import br.com.conta_bancaria.conta_bancaria.builders.ClienteBuilder;
import br.com.conta_bancaria.conta_bancaria.dto.requests.cliente.*;
import br.com.conta_bancaria.conta_bancaria.models.Cliente;

public class ClienteFactory {
    public static Cliente fromRequest(CreateClienteRequest request) {
        return new ClienteBuilder()
            .nome(request.getNome())
            .endereco(request.getEndereco())
            .telefone(request.getTelefone())
            .cpf(request.getCpf())
            .agencia(request.getAgencia())
            .codigoBanco(request.getCodigoBanco())
            .build();
    }

    public static Cliente fromUpdate(UpdateClienteRequest request) {
        return new ClienteBuilder()
            .nome(request.getNome())
            .endereco(request.getEndereco())
            .telefone(request.getTelefone())
            .cpf(request.getCpf())
            .agencia(request.getAgencia())
            .codigoBanco(request.getCodigoBanco())
            .build();
    }    
}
