package br.com.conta_bancaria.conta_bancaria.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

import br.com.conta_bancaria.conta_bancaria.builders.ViaCepBuilder;
import br.com.conta_bancaria.conta_bancaria.models.ViaCep;
import br.com.conta_bancaria.conta_bancaria.dto.responses.viacep.ViaCepResponse;
import br.com.conta_bancaria.conta_bancaria.interfaces.ViaCepDto;

import java.util.Optional;

@Service
public class ViaCepService {

    private static final String VIA_CEP_URL = "https://viacep.com.br/ws/{cep}/json/";

    private final RestTemplate restTemplate;

    public ViaCepService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<ViaCepDto> buscarEndereco(String cep) {
        if (cep == null || !cep.matches("\\d{8}")) {
            return Optional.empty();
        }

        try {
            ViaCepResponse response = restTemplate.getForObject(VIA_CEP_URL, ViaCepResponse.class, cep);

            if (response == null || response.getCep() == null) {
                return Optional.empty();
            }

            ViaCep endereco = new ViaCepBuilder()
                .cep(response.getCep())
                .logradouro(response.getLogradouro())
                .complemento(response.getComplemento())
                .bairro(response.getBairro())
                .localidade(response.getLocalidade())
                .uf(response.getUf())
                .build();

            return Optional.of(endereco);

        } catch (RestClientException e) {
            return Optional.empty();
        }
    }
}
