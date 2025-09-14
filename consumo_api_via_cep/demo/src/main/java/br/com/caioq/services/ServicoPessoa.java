package br.com.caioq.services;

import br.com.caioq.models.Pessoa;

public class ServicoPessoa {
    
    public ServicoPessoa() {}
    
    public static Pessoa criarPessoa(String nome, String email, String endereco, int idade) {
        try {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(nome);
            pessoa.setEmail(email);
            pessoa.setEndereco(endereco);
            pessoa.setIdade(idade);
            return pessoa; 
        } catch (Exception e) {
            System.err.println("Erro ao criar pessoa: " + e.getMessage());
            return null;
        }
    }
}