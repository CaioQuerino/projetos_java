package br.com.conta_bancaria.conta_bancaria.builders;

import br.com.conta_bancaria.conta_bancaria.models.ViaCep;

public class ViaCepBuilder {
    
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    public ViaCepBuilder cep(String cep) {
        this.cep = cep;
        return this;
    }

    public ViaCepBuilder logradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    
    public ViaCepBuilder bairro(String bairro) {
        this.bairro = bairro;
        return this;
    }
    
    public ViaCepBuilder localidade(String localidade) {
        this.localidade = localidade;
        return this;
    }

    public ViaCepBuilder uf(String uf) {
        this.uf = uf;
        return this;
    }

    public ViaCep build() {
        ViaCep viaCep = new ViaCep();
        viaCep.setCep(this.cep);
        viaCep.setLogradouro(this.logradouro);
        viaCep.setBairro(this.bairro);
        viaCep.setLocalidade(this.localidade);
        viaCep.setUf(this.uf);
        return viaCep;
    }
}