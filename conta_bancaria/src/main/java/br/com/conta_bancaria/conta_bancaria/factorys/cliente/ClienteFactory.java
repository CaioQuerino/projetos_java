package br.com.conta_bancaria.conta_bancaria.factorys.cliente;

import br.com.conta_bancaria.conta_bancaria.dto.requests.cliente.*;
import br.com.conta_bancaria.conta_bancaria.models.Cliente;

public class ClienteFactory {
    public static Cliente fromCreate(CreateClienteRequest request) {
        Cliente cliente = Cliente.builder()
            .nome(request.getNome())
            .endereco(request.getEndereco())
            .telefone(request.getTelefone())
            .cpf(request.getCpf())
            .agencia(request.getAgencia())
            .codigoBanco(request.getCodigoBanco())
            .build();
            return cliente;
    }

    public static Cliente fromUpdate(UpdateClienteRequest request) {
        Cliente cliente = Cliente.builder()
            .nome(request.getNome())
            .endereco(request.getEndereco())
            .telefone(request.getTelefone())
            .cpf(request.getCpf())
            .agencia(request.getAgencia())
            .codigoBanco(request.getCodigoBanco())
            .build();
            return cliente;
    }    
}
