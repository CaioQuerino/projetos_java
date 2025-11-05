package br.com.conta_bancaria.conta_bancaria.factorys.viacep;

import br.com.conta_bancaria.conta_bancaria.dto.responses.viacep.ViaCepResponse;
import br.com.conta_bancaria.conta_bancaria.models.ViaCep;

public class ViaCepFactory {
    public static ViaCep fromCreate(ViaCepResponse request) 
    {
        ViaCep viaCep = ViaCep.builder()
            .cep(request.getCep())
            .logradouro(request.getLogradouro())
            .bairro(request.getBairro())
            .localidade(request.getLocalidade())
            .uf(request.getUf())
            .build();
            return viaCep;
    }

    public static ViaCep fromUpdate(ViaCepResponse request)
    {
        ViaCep vs = ViaCep.builder()
            .cep(request.getCep())
            .logradouro(request.getLogradouro())
            .bairro(request.getBairro())
            .localidade(request.getLocalidade())
            .uf(request.getUf())
            .build();
            return vs;
    }
}
