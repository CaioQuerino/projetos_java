package br.com.conta_bancaria.conta_bancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.conta_bancaria.conta_bancaria.models.Cliente;

@Repository
public interface RepositoryCliente extends JpaRepository<Cliente, Long> {
    Cliente findByCpf(String cpf);
}