package br.com.conta_bancaria.conta_bancaria.interfaces;

import br.com.conta_bancaria.conta_bancaria.models.ViaCep;

public interface ClienteRequest {
    String getNome();
    ViaCep getEndereco();
    String getTelefone();
    String getCpf();
    String getAgencia();
    String getCodigoBanco();
}