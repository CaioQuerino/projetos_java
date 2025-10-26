package br.com.task.task.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.task.task.services.UserService;
import br.com.task.task.models.User;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    
    public UserController (UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping
    public User createUser(@RequestBody  User user) {
        return userService.createUser(user);
    }
}
