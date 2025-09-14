package br.com.consumo_api_via_cep.models;

import br.com.consumo_api_via_cep.interfaces.IUsuario;

public class Usuario implements IUsuario {
    private int id;
    private String nome;

    Usuario() {};

    Usuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
}
