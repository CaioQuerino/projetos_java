package br.com.conta_bancaria.conta_bancaria.models;

import jakarta.persistence.*;

import lombok.*;


@Entity
@Table(name = "conta")

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Conta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String numeroConta;
    private String tipoConta;
    private double saldo;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "banco_id")
    private Banco banco;
    
    private String senha;

    public Conta() {}
}