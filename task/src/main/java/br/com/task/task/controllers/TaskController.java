package br.com.task.task.controllers;

import org.springframework.web.bind.annotation.*;
import br.com.task.task.models.Task;
import br.com.task.task.services.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }
}
