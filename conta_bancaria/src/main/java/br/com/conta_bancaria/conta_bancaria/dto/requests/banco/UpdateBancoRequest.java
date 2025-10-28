package br.com.conta_bancaria.conta_bancaria.dto.requests.banco;

import br.com.conta_bancaria.conta_bancaria.models.ViaCep;

public class UpdateBancoRequest {
    private String nome;
    private ViaCep endereco;
    private String telefone;
    private String cnpj;
    private String agencia;
    private String codigoBanco;

    public UpdateBancoRequest() {}

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }
    
    public ViaCep getEndereco() { return endereco; }

    public void setEndereco(ViaCep endereco) { this.endereco = endereco; }

    public String getTelefone() { return telefone; }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCnpj() { return cnpj; }

    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getAgencia() { return agencia; }

    public void setAgencia(String agencia) { this.agencia = agencia; }

    public String getCodigoBanco() { return codigoBanco; }

    public void setCodigoBanco(String codigoBanco) { this.codigoBanco = codigoBanco; }
}