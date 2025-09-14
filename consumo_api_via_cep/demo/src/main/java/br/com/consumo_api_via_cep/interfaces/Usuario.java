package br.com.consumo_api_via_cep.interfaces;

public interface Usuario {
    abstract int getId();
    abstract String getNome();
    abstract void setNome(String nome);
}
