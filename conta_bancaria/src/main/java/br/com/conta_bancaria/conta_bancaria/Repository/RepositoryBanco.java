package br.com.conta_bancaria.conta_bancaria.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.conta_bancaria.conta_bancaria.models.Banco;

@Repository
public interface RepositoryBanco extends JpaRepository<Banco, Long> {
    Optional<Banco> findByCnpj(String cnpj);
    Optional<Banco> findByNome(String nome);
    Optional<Banco> findByCodigoBanco(String codigoBanco);
    List<Banco> findAllByCodigoBanco(String codigoBanco);
    boolean existsByCodigoBanco(String codigoBanco);
}