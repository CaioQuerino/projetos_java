package br.com.conta_bancaria.conta_bancaria.models;

import br.com.conta_bancaria.conta_bancaria.interfaces.ViaCepDto;

public class ViaCep implements ViaCepDto {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public ViaCep(
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf
    ) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public static ViaCep fromViaCepDto(ViaCep viaCep) {
        return new ViaCep(
            viaCep.cep,
            viaCep.logradouro,
            viaCep.complemento,
            viaCep.bairro,
            viaCep.logradouro,
            viaCep.uf
        );
    }
}
