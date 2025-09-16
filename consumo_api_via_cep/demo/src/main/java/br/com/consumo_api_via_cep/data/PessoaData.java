package br.com.consumo_api_via_cep.data;

import java.util.ArrayList;
import java.util.List;
import br.com.consumo_api_via_cep.models.Pessoa;
import br.com.consumo_api_via_cep.models.UsuarioDB;

public class PessoaData extends UsuarioDB {
    
    private ArrayList<Pessoa> pessoas = new ArrayList<>();
    private int ultimoId = 0;
    
    @Override
    public String salvar(Object obj) {
        if (obj instanceof Pessoa) {
            Pessoa pessoa = (Pessoa) obj;
            
            for (Pessoa p : pessoas) {
                if (p.getEmail().equals(pessoa.getEmail())) {
                    return "Erro: Já existe uma pessoa com este email";
                }
            }
            
            int novoId = ++ultimoId;
            pessoa.setId(novoId);
            
            pessoas.add(pessoa);
            return "Pessoa salva com sucesso! ID: " + novoId;
        }
        return "Erro: Objeto não é uma Pessoa";
    }
    
    @Override
    public Object buscarPorId(int id) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }
    
    public Pessoa buscarPorEmail(String email) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getEmail().equals(email)) {
                return pessoa;
            }
        }
        return null;
    }
    
    public List<Pessoa> buscarPorNome(String nome) {
        List<Pessoa> resultado = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultado.add(pessoa);
            }
        }
        return resultado;
    }
    
    @Override
    public String atualizar(int id, Object obj) {
        if (obj instanceof Pessoa) {
            Pessoa novaPessoa = (Pessoa) obj;
            
            for (int i = 0; i < pessoas.size(); i++) {
                Pessoa pessoa = pessoas.get(i);
                if (pessoa.getId() == id) {
                    for (Pessoa p : pessoas) {
                        if (p.getId() != id && p.getEmail().equals(novaPessoa.getEmail())) {
                            return "Erro: Já existe outra pessoa com este email";
                        }
                    }
                    
                    novaPessoa.setId(id); // Mantém o mesmo ID
                    pessoas.set(i, novaPessoa);
                    
                    return "Pessoa atualizada com sucesso! ID: " + id;
                }
            }
            return "Erro: Pessoa não encontrada com ID: " + id;
        }
        return "Erro: Objeto não é uma Pessoa";
    }
    
    @Override
    public String deletar(int id) {
        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa pessoa = pessoas.get(i);
            if (pessoa.getId() == id) {
                pessoas.remove(i);
                return "Pessoa deletada com sucesso! ID: " + id;
            }
        }
        return "Erro: Pessoa não encontrada com ID: " + id;
    }
    
    public List<Pessoa> listarTodasPessoas() {
        return new ArrayList<>(pessoas);
    }
    
    public int getTotalPessoas() {
        return pessoas.size();
    }
    
    public void limparDados() {
        pessoas.clear();
        ultimoId = 0;
    }

    @Override
    public Object[] buscarTodos() {
        return null;
    }
}