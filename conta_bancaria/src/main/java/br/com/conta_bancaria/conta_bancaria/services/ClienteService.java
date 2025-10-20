package br.com.conta_bancaria.conta_bancaria.services;

import br.com.conta_bancaria.conta_bancaria.models.Cliente;
import br.com.conta_bancaria.conta_bancaria.repository.RepositoryCliente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final RepositoryCliente repository;

    public ClienteService(RepositoryCliente repository) {
        this.repository = repository;
    }

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente novoCliente) {
        return repository.findById(id)
                .map(cliente -> {
                    cliente.setNome(novoCliente.getNome());
                    cliente.setCpf(novoCliente.getCpf());
                    cliente.setTelefone(novoCliente.getTelefone());
                    cliente.setAgencia(novoCliente.getAgencia());
                    cliente.setCodigoBanco(novoCliente.getCodigoBanco());
                    cliente.setEndereco(novoCliente.getEndereco());
                    return repository.save(cliente);
                })
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
