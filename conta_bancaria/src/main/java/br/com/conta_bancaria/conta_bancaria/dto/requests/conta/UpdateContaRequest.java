package br.com.conta_bancaria.conta_bancaria.dto.requests.conta;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateContaRequest {
    private String tipoConta;
    private double saldo;
    private Long clienteId;
    private Long bancoId;
    private String senha;
}
