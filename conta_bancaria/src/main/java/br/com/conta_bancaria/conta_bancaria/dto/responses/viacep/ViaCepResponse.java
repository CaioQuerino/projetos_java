package br.com.conta_bancaria.conta_bancaria.dto.responses.viacep;

import lombok.*;

@Getter
@AllArgsConstructor
public class ViaCepResponse {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
}