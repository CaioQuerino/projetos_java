package br.com.conta_bancaria.conta_bancaria.dto.requests.cliente;

import br.com.conta_bancaria.conta_bancaria.models.ViaCep;

public class UpdateClienteRequest {
    private String nome;
    private ViaCep endereco;
    private String telefone;
    private String cpf;
    private String agencia;
    private String codigoBanco;

    public UpdateClienteRequest() {}

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public ViaCep getEndereco() { return endereco; }

    public void setEndereco(ViaCep endereco) { this.endereco = endereco; }

    public String getTelefone() { return telefone; }
    
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getAgencia() { return agencia; }

    public void setAgencia(String agencia) { this.agencia = agencia; }

    public String getCodigoBanco() { return codigoBanco; }
    
    public void setCodigoBanco(String codigoBanco) { this.codigoBanco = codigoBanco; }
}