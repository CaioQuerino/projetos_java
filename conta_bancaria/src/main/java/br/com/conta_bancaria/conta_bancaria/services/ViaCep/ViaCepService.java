package br.com.conta_bancaria.conta_bancaria.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

import br.com.conta_bancaria.conta_bancaria.interfaces.ViaCepDto;
import br.com.conta_bancaria.conta_bancaria.models.ViaCep;

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
            System.err.println("CEP inválido: " + cep);
            return Optional.empty();
        }

        try {
            ViaCep endereco = restTemplate.getForObject(VIA_CEP_URL, ViaCep.class, cep);

            if (endereco == null || endereco.getCep() == null) {
                System.out.println("CEP não encontrado: " + cep);
                return Optional.empty();
            }

            System.out.println("Endereço encontrado: " + endereco);
            return Optional.of(endereco);

        } catch (RestClientException e) {
            System.err.println("Erro ao buscar CEP " + cep + ": " + e.getMessage());
            return Optional.empty();
        }
    }
}
