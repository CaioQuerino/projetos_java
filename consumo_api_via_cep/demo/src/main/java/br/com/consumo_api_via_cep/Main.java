package br.com.consumo_api_via_cep;

import br.com.consumo_api_via_cep.models.Pessoa;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CADASTRO DE PESSOAS COM ENDEREÇO POR CEP ===\n");
        
        Pessoa pessoa1 = new Pessoa(
            "João Silva", 
            "joao@email.com", 
            "Rua das Flores, 123 - São Paulo/SP", 
            30
        );
        
        Pessoa pessoa2 = new Pessoa(
            "Maria Santos", 
            "maria@email.com", 
            "01001000", 
            25,
            true 
        );
        
        Pessoa pessoa3 = new Pessoa(
            "Carlos Oliveira", 
            "carlos@empresa.com", 
            "00000000", 
            30,
            true
        );
        
        System.out.println("Pessoas cadastradas:");
        System.out.println("1: " + pessoa1);
        System.out.println("2: " + pessoa2);
        System.out.println("3: " + pessoa3);

        System.out.println("\n=== ATUALIZANDO ENDEREÇO POR CEP ===");
        System.out.println("Endereço atual da pessoa 1: " + pessoa1.getEndereco());
        pessoa1.setEnderecoPorCep("20040002");
        System.out.println("Novo endereço da pessoa 1: " + pessoa1.getEndereco());

        System.out.println("\n=== TESTANDO OUTRO CEP ===");
        Pessoa pessoa4 = new Pessoa(
            "Ana Costa", 
            "ana@empresa.com", 
            "30130005",
            28,
            true
        );
        System.out.println("Pessoa 4: " + pessoa4);
    }
}