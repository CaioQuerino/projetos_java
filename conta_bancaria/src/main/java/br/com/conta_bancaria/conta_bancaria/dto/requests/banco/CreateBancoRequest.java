package br.com.conta_bancaria.conta_bancaria.dto.requests.banco;

import br.com.conta_bancaria.conta_bancaria.interfaces.BancoRequest;
import br.com.conta_bancaria.conta_bancaria.models.ViaCep;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class CreateBancoRequest implements BancoRequest {
    private String nome;
    private ViaCep endereco;
    private String telefone;
    private String cnpj;
    private String agencia;
    private String codigoBanco;
}