package br.com.conta_bancaria.conta_bancaria.dto.requests.cliente;

import br.com.conta_bancaria.conta_bancaria.models.ViaCep;
import br.com.conta_bancaria.conta_bancaria.interfaces.ClienteRequest;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class UpdateClienteRequest implements ClienteRequest {
    private String nome;
    private ViaCep endereco;
    private String telefone;
    private String cpf;
    private String agencia;
    private String codigoBanco;
}