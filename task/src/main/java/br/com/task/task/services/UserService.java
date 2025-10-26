package br.com.task.task.services;

import br.com.task.task.repository.RepositoryUser;
import org.springframework.stereotype.Service;

import br.com.task.task.models.User;

@Service
public class UserService {

    private final RepositoryUser repositoryUser;
    
    public UserService(RepositoryUser repositoryUser) 
    {
        this.repositoryUser = repositoryUser;
    }
    
    public User createUser(User user) 
    {
        return repositoryUser.save(user);
    }
}