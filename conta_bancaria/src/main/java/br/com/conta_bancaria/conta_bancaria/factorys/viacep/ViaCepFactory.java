package br.com.conta_bancaria.conta_bancaria.factorys.viacep;

import br.com.conta_bancaria.conta_bancaria.interfaces.ViaCepRequest;
import br.com.conta_bancaria.conta_bancaria.models.ViaCep;

public class ViaCepFactory {

    private static ViaCep from(ViaCepRequest request) 
    {
        return ViaCep.builder()
            .cep(request.getCep())
            .logradouro(request.getLogradouro())
            .bairro(request.getBairro())
            .localidade(request.getLocalidade())
            .uf(request.getUf())
            .build();
    }

    public static ViaCep fromRequest(Object request) {
        return request instanceof ViaCepRequest
            ? from((ViaCepRequest) request)
            : null;
    }  
}
