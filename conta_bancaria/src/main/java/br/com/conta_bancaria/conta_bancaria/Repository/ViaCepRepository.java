package br.com.conta_bancaria.conta_bancaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.conta_bancaria.conta_bancaria.models.ViaCep;

public interface ViaCepRepository extends JpaRepository<ViaCep, Long> {
    Optional<ViaCep> findByCep(String cep);
}