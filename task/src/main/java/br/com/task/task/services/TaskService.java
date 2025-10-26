package br.com.task.task.services;

import org.springframework.stereotype.Service;

import br.com.task.task.models.Task;
import br.com.task.task.repository.RepositoryTask;

@Service
public class TaskService {
    private final RepositoryTask repositoryTask;
    
    public TaskService(RepositoryTask repositoryTask) 
    {
        this.repositoryTask = repositoryTask;
    }    
    
    public Task createTask(Task task) 
    {
        return repositoryTask.save(task);
    }
}
