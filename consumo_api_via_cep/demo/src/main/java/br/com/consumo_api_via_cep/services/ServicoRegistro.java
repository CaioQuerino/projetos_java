package br.com.consumo_api_via_cep.services;

import br.com.consumo_api_via_cep.data.PessoaData;
import br.com.consumo_api_via_cep.models.Pessoa;

public class ServicoRegistro {
    
    private PessoaData pessoaData;
    
    public ServicoRegistro() {
        this.pessoaData = new PessoaData();
    }
    
    public ServicoRegistro(PessoaData pessoaData) {
        this.pessoaData = pessoaData;
    }
    
    public String registrarPessoa(String nome, String email, String endereco, int idade) {
        Pessoa pessoa = ServicoPessoa.criarPessoaValidada(nome, email, endereco, idade);
        
        if (pessoa != null) {
            return pessoaData.salvar(pessoa);
        } else {
            return "Erro: Não foi possível criar a pessoa. Verifique os dados.";
        }
    }
    
    public String registrarPessoaComCep(String nome, String email, String cep, int idade) {
        Pessoa pessoa = ServicoPessoa.criarPessoaComCep(nome, email, cep, idade);
        
        if (pessoa != null) {
            return pessoaData.salvar(pessoa);
        } else {
            return "Erro: Não foi possível criar a pessoa. Verifique os dados.";
        }
    }
} 