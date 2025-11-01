package br.com.conta_bancaria.conta_bancaria.models;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cliente")

@Getter
@Setter
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @Embedded
    private ViaCep endereco;
    
    private String telefone;
    private String cpf;
    private String agencia;
    private String codigoBanco;

    public Cliente() {}

    public Cliente(String nome, ViaCep endereco, String telefone, String cpf, 
                                        String agencia, String codigoBanco) {

        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.agencia = agencia;
        this.codigoBanco = codigoBanco;
    }
}