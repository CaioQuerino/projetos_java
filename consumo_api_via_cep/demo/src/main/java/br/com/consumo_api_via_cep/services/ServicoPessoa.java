package br.com.consumo_api_via_cep.services;

import br.com.consumo_api_via_cep.models.Pessoa;

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

    public static boolean validarEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return email.contains("@") && email.contains(".");
    }

    public static boolean validarIdade(int idade) {
        return idade >= 0 && idade <= 150;
    }

    public static Pessoa criarPessoaValidada(String nome, String email, String endereco, int idade) {
        if (!validarEmail(email)) {
            System.out.println("Email inválido: " + email);
            return null;
        }
        
        if (!validarIdade(idade)) {
            System.out.println("Idade inválida: " + idade);
            return null;
        }
        
        return criarPessoa(nome, email, endereco, idade);
    }
}