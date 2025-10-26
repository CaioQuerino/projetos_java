package br.com.task.task.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.task.task.models.User;

@Repository
public interface RepositoryUser extends JpaRepository<User, Long> {
    Optional<User> findUser(Long id);

}