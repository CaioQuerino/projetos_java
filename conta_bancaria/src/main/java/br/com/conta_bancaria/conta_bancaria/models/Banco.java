package br.com.conta_bancaria.conta_bancaria.models;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "banco")

@Getter
@Setter
@AllArgsConstructor
@Builder
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
}