package br.com.conta_bancaria.conta_bancaria.dto.requests.cliente;

import br.com.conta_bancaria.conta_bancaria.models.ViaCep;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class CreateClienteRequest {
    private String nome;
    private ViaCep endereco;
    private String telefone;
    private String cpf;
    private String agencia;
    private String codigoBanco;
}