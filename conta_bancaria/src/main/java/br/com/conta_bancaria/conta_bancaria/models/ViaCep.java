package br.com.conta_bancaria.conta_bancaria.models;

import br.com.conta_bancaria.conta_bancaria.interfaces.ViaCepRequest;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "enderecos")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ViaCep implements ViaCepRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 9)
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    public ViaCep() {}
}