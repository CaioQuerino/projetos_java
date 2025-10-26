package br.com.task.task.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tarefa;
    private String descricao;
    private boolean concluido = false;

    public Task() {}

    public Task(Long id, String tarefa, String descricao, boolean concluido) 
    {
        this.id = id;
        this.tarefa = tarefa;
        this.descricao = descricao;
        this.concluido = concluido;
    }

    public Long getId() { return this.id; }

    public void setId(Long id) { this.id = id; }

    public String getTarefa() { return tarefa; }

    public void setTarefa(String tarefa) { this.tarefa = tarefa; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public boolean getConcluido() { return concluido; }

    public void setConcluido(boolean concluido) { this.concluido = concluido; }
}