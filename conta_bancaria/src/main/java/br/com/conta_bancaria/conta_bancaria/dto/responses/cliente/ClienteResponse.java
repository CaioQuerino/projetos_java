package br.com.conta_bancaria.conta_bancaria.dto.responses.cliente;

import br.com.conta_bancaria.conta_bancaria.models.ViaCep;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class ClienteResponse {
    private Long id;
    private String nome;
    private ViaCep endereco;
    private String telefone;
    private String cpf;
    private String agencia;
    private String codigoBanco;
}