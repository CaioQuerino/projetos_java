package br.com.conta_bancaria.conta_bancaria.models;

import br.com.conta_bancaria.conta_bancaria.interfaces.ViaCepDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "enderecos")
@Getter
@Setter
public class ViaCep implements ViaCepDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 9)
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public ViaCep() {}
}