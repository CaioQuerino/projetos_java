package br.com.task.task.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")

public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Task task;
    
    public User() {}

    public User(Long id,String nome, String email, String senha) 
    {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    public Long getId() { return this.id; }
    
    public Long setId(Long id) { return this.id; }

    public Task getTask() { return this.task; } 

    public void setTask(Task task) { this.task = task; } 
    
    public String getNome() { return this.nome; }
    
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return this.email; }

    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return this.senha; }
    
    public void setSenha(String senha) { this.senha = senha; }
}
