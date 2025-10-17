package br.com.conta_bancaria.conta_bancaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import br.com.conta_bancaria.conta_bancaria.models.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    Optional<Conta> findByNumeroConta(String numeroConta);
}
