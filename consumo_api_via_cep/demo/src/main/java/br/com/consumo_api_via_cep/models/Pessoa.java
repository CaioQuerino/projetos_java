package br.com.consumo_api_via_cep.models;

import br.com.consumo_api_via_cep.services.ServicoEndereco;

public class Pessoa extends Usuario {
    private String email;
    private String endereco;
    private int idade;

    public Pessoa() {}

    public Pessoa(int id, String nome, String email, String endereco, int idade) {
        this.email = email;
        this.endereco = endereco;
        this.idade = idade;
    }

    public Pessoa(int id, String nome, String email, String cep, int idade, boolean usarCep) {

        this.email = email;
        if (usarCep) {
            this.endereco = ServicoEndereco.buscarEnderecoPorCep(cep);
        } else {
            this.endereco = cep; 
        }
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getIdade() {
        return idade;
    }

    // Setters

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEnderecoPorCep(String cep) {
        this.endereco = ServicoEndereco.buscarEnderecoPorCep(cep);
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + getNome() + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", idade=" + idade +
                '}';
    }
}