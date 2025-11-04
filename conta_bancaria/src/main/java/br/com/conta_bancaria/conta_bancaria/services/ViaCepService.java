package br.com.conta_bancaria.conta_bancaria.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

import br.com.conta_bancaria.conta_bancaria.builders.ViaCepBuilder;
import br.com.conta_bancaria.conta_bancaria.models.ViaCep;
import br.com.conta_bancaria.conta_bancaria.dto.responses.viacep.ViaCepResponse;
import br.com.conta_bancaria.conta_bancaria.interfaces.ViaCepDto;
import br.com.conta_bancaria.conta_bancaria.repository.ViaCepRepository;

import java.util.Optional;

@Service
public class ViaCepService {

    private static final String VIA_CEP_URL = "https://viacep.com.br/ws/{cep}/json/";

    private final RestTemplate restTemplate;
    private final ViaCepRepository viaCepRepository;

    public ViaCepService(RestTemplate restTemplate, ViaCepRepository viaCepRepository) {
        this.restTemplate = restTemplate;
        this.viaCepRepository = viaCepRepository;
    }

    /**
     * Busca endereço no ViaCEP e converte para DTO
     */
    private Optional<ViaCepDto> buscarEndereco(String cep) {
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
                    .bairro(response.getBairro())
                    .localidade(response.getLocalidade())
                    .uf(response.getUf())
                    .build();

            return Optional.of(endereco);

        } catch (RestClientException e) {
            return Optional.empty();
        }
    }

    /**
     * Busca o endereço no banco ou na API do ViaCEP.
     * Se não existir, salva no banco e retorna a entidade persistida.
     */
    public ViaCep buscarOuSalvarEndereco(String cep) {
        if (cep == null || cep.isBlank()) {
            throw new IllegalArgumentException("CEP inválido");
        }

        String cepLimpo = cep.replaceAll("\\D", "");

        Optional<ViaCep> enderecoExistente = viaCepRepository.findByCep(cepLimpo);
        if (enderecoExistente.isPresent()) {
            return enderecoExistente.get();
        }

        Optional<ViaCepDto> enderecoViaCep = buscarEndereco(cepLimpo);

        if (enderecoViaCep.isPresent() && enderecoViaCep.get() instanceof ViaCep novoEndereco) {
            novoEndereco.setCep(cepLimpo);
            return viaCepRepository.save(novoEndereco);
        }

        throw new RuntimeException("Endereço não encontrado para o CEP: " + cep);
    }
}
