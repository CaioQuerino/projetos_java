package br.com.conta_bancaria.conta_bancaria.dto.requests.login;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class LoginRequest {
    private String numeroConta;
    private String senha;
}