package br.com.consumo_api_via_cep.services;

import java.util.List;
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
    
    public String registrarPessoa(Pessoa pessoa) {
        if (pessoa != null) {
            if (!ServicoPessoa.validarEmail(pessoa.getEmail())) {
                return "Erro: Email inválido";
            }
            
            if (!ServicoPessoa.validarIdade(pessoa.getIdade())) {
                return "Erro: Idade inválida";
            }
            
            return pessoaData.salvar(pessoa);
        } else {
            return "Erro: Pessoa não pode ser nula";
        }
    }
    
    public Pessoa buscarPessoaPorId(int id) {
        return (Pessoa) pessoaData.buscarPorId(id);
    }
    
    public Pessoa buscarPessoaPorEmail(String email) {
        return pessoaData.buscarPorEmail(email);
    }
    
    public List<Pessoa> buscarPessoasPorNome(String nome) {
        return pessoaData.buscarPorNome(nome);
    }
    
    public List<Pessoa> listarTodasPessoas() {
        return pessoaData.listarTodasPessoas();
    }
    
    public String atualizarPessoa(int id, String nome, String email, String endereco, int idade) {
        Pessoa pessoaExistente = (Pessoa) pessoaData.buscarPorId(id);
        
        if (pessoaExistente == null) {
            return "Erro: Pessoa não encontrada com ID: " + id;
        }
        
        Pessoa pessoaAtualizada = ServicoPessoa.criarPessoaValidada(nome, email, endereco, idade);
        
        if (pessoaAtualizada != null) {
            pessoaAtualizada.setId(id); // Mantém o mesmo ID
            return pessoaData.atualizar(id, pessoaAtualizada);
        } else {
            return "Erro: Dados inválidos para atualização";
        }
    }
    
    public String atualizarPessoaComCep(int id, String nome, String email, String cep, int idade) {
        Pessoa pessoaExistente = (Pessoa) pessoaData.buscarPorId(id);
        
        if (pessoaExistente == null) {
            return "Erro: Pessoa não encontrada com ID: " + id;
        }
        
        Pessoa pessoaAtualizada = ServicoPessoa.criarPessoaComCep(nome, email, cep, idade);
        
        if (pessoaAtualizada != null) {
            pessoaAtualizada.setId(id); // Mantém o mesmo ID
            return pessoaData.atualizar(id, pessoaAtualizada);
        } else {
            return "Erro: Dados inválidos para atualização";
        }
    }
    
    public String deletarPessoa(int id) {
        return pessoaData.deletar(id);
    }
    
    public int getTotalPessoasRegistradas() {
        return pessoaData.getTotalPessoas();
    }
    
    public PessoaData getPessoaData() {
        return pessoaData;
    }
}