package br.com.conta_bancaria.conta_bancaria.dto.requests.conta;

import lombok.*;
import br.com.conta_bancaria.conta_bancaria.interfaces.ContaRequest;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateContaRequest implements ContaRequest {
    private String tipoConta;
    private double saldo;
    private Long clienteId;
    private Long bancoId;
    private String senha;
}