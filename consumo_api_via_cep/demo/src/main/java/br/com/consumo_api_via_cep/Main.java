package br.com.consumo_api_via_cep;

import br.com.consumo_api_via_cep.services.ServicoRegistro;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE REGISTRO DE PESSOAS ===\n");
        
        ServicoRegistro servicoRegistro = new ServicoRegistro();
        
        System.out.println("1. " + servicoRegistro.registrarPessoa(
            "João Silva", "joao@email.com", "Rua das Flores, 123", 30
        ));
        
        System.out.println("2. " + servicoRegistro.registrarPessoaComCep(
            "Maria Santos", "maria@email.com", "01001000", 25
        ));
        
        System.out.println("3. " + servicoRegistro.registrarPessoa(
            "Carlos Oliveira", "carlos@empresa.com", "Av. Paulista, 1000", 35
        ));
        
        System.out.println("\n=== PESSOAS CADASTRADAS ===");
        servicoRegistro.listarTodasPessoas().forEach(System.out::println);
        
        System.out.println("\n=== BUSCA POR ID ===");
        System.out.println(servicoRegistro.buscarPessoaPorId(2));
        
        System.out.println("\n=== ATUALIZAÇÃO ===");
        System.out.println(servicoRegistro.atualizarPessoa(
            1, "João da Silva", "joao.silva@email.com", "Rua Nova, 456", 31
        ));
        
        System.out.println("\n=== LISTA FINAL ===");
        servicoRegistro.listarTodasPessoas().forEach(System.out::println);
        
        System.out.println("\nTotal de pessoas: " + servicoRegistro.getTotalPessoasRegistradas());
    }
}