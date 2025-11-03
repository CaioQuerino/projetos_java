package br.com.conta_bancaria.conta_bancaria.dto.requests.login;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class LoginRequest {
    private String numeroConta;
    private String senha;
}