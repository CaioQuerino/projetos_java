package br.com.conta_bancaria.conta_bancaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.conta_bancaria.conta_bancaria.models.Banco;
import br.com.conta_bancaria.conta_bancaria.repository.RepositoryBanco;

@Service
public class BancoService {

    private final RepositoryBanco repository;

    @Autowired
    public BancoService(RepositoryBanco repository) {
        this.repository = repository;
    }

    public List<Banco> listarTodos() {
        return repository.findAll();
    }

    public Optional<Banco> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<Banco> buscarPorNome(String nome) {
        return repository.findByNome(nome);
    }

    public Optional<Banco> buscarPorCodigoBanco(String codigoBanco) {
        return repository.findByCodigoBanco(codigoBanco);
    }

    public Banco salvar(Banco banco) {
        return repository.save(banco);
    }

    public Banco atualizar(Long id, Banco bancoAtualizado) {
        return repository.findById(id)
            .map(banco -> {
                banco.setNome(bancoAtualizado.getNome());
                banco.setCnpj(bancoAtualizado.getCnpj());
                banco.setTelefone(bancoAtualizado.getTelefone());
                banco.setAgencia(bancoAtualizado.getAgencia());
                banco.setCodigoBanco(bancoAtualizado.getCodigoBanco());
                banco.setEndereco(bancoAtualizado.getEndereco());
                return repository.save(banco);
            })
            .orElseThrow(() -> new RuntimeException("Banco não encontrado com id: " + id));
    }

    public void deletar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Banco não encontrado com id: " + id);
        }
    }

    public boolean existePorId(Long id) {
        return repository.existsById(id);
    }

    public List<Banco> buscarTodosPorCodigoBanco(String codigoBanco) {
        return repository.findAllByCodigoBanco(codigoBanco);
    }
}