package br.com.conta_bancaria.conta_bancaria.factorys.cliente;

import br.com.conta_bancaria.conta_bancaria.interfaces.ClienteRequest;
import br.com.conta_bancaria.conta_bancaria.models.Cliente;

public class ClienteFactory {
    private static Cliente from(ClienteRequest request) {
        return Cliente.builder()
            .nome(request.getNome())
            .endereco(request.getEndereco())
            .telefone(request.getTelefone())
            .cpf(request.getCpf())
            .agencia(request.getAgencia())
            .codigoBanco(request.getCodigoBanco())
            .build();
    }

    public static Cliente fromRequest(Object request) {
        return request instanceof ClienteRequest
            ? from((ClienteRequest) request)
            : null;
    }  
}
