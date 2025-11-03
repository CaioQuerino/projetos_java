package br.com.conta_bancaria.conta_bancaria.dto.responses.banco;

import br.com.conta_bancaria.conta_bancaria.models.ViaCep;

import lombok.*;

@Getter
@AllArgsConstructor
public class BancoResponse {
    private Long id;
    private String nome;
    private ViaCep endereco;
    private String telefone;
    private String cnpj;
    private String agencia;
    private String codigoBanco;
}