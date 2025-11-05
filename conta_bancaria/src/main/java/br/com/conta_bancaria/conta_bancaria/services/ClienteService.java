package br.com.conta_bancaria.conta_bancaria.services;

import br.com.conta_bancaria.conta_bancaria.models.*;
import br.com.conta_bancaria.conta_bancaria.repository.RepositoryCliente;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {

    private final RepositoryCliente repository;
    private final ViaCepService viaCepService;

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Cliente salvar(Cliente cliente) {
        if (cliente.getEndereco() != null && cliente.getEndereco().getCep() != null) {
            ViaCep endereco = viaCepService.buscarOuSalvarEndereco(cliente.getEndereco().getCep());
            cliente.setEndereco(endereco);
        }      
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
