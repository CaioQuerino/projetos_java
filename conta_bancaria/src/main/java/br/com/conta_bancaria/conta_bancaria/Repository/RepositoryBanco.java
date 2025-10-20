package br.com.conta_bancaria.conta_bancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.conta_bancaria.conta_bancaria.models.Banco;

@Repository
public interface RepositoryBanco extends JpaRepository<Banco, Long> {
    Banco findByCnpj(String cnpj);
}