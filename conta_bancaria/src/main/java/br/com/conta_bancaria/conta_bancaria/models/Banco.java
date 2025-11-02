package br.com.conta_bancaria.conta_bancaria.models;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "banco")

@Getter
@Setter
public class Banco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private ViaCep endereco;
    
    private String telefone;
    private String cnpj;
    private String agencia;
    private String codigoBanco;

    public Banco() {}

    public Banco(String nome, ViaCep endereco, String telefone, String cnpj, 
                                       String agencia, String codigoBanco) {

        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.agencia = agencia;
        this.codigoBanco = codigoBanco;
    }
}