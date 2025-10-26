package br.com.task.task.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.task.task.models.Task;

@Repository
public interface RepositoryTask extends JpaRepository<Task, Long> {
    Optional<Task> findByTitulo(String titulo);
    Optional<Task> findByDescricao(String descricao);
}