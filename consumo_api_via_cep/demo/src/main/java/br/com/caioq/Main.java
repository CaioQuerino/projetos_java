package br.com.caioq;

import br.com.caioq.models.Pessoa;

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
    }
}