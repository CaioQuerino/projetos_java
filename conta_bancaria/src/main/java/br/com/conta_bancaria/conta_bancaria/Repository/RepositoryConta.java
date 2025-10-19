package br.com.conta_bancaria.conta_bancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import br.com.conta_bancaria.conta_bancaria.models.Conta;
import java.util.List;

@Repository
public interface RepositoryConta extends JpaRepository<Conta, Long> {
    Optional<Conta> findByNumeroConta(String numeroConta);
    
    List<Conta> findAllByOrderByIdAsc();

}
