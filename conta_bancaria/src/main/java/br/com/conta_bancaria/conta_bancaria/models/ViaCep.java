package br.com.conta_bancaria.conta_bancaria.models;

import br.com.conta_bancaria.conta_bancaria.interfaces.ViaCepDto;
import jakarta.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ViaCep implements ViaCepDto {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public ViaCep() {}

    public ViaCep(String cep, String logradouro, String complemento, 
                  String bairro, String localidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }
}