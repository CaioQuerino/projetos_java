package br.com.conta_bancaria.conta_bancaria.dto.responses.cliente;

import br.com.conta_bancaria.conta_bancaria.models.ViaCep;

public class ClienteResponse {
    private Long id;
    private String nome;
    private ViaCep endereco;
    private String telefone;
    private String cpf;
    private String agencia;
    private String codigoBanco;

    public ClienteResponse() {}

    public ClienteResponse(Long id, String nome, ViaCep endereco, String telefone, 
                          String cpf, String agencia, String codigoBanco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.agencia = agencia;
        this.codigoBanco = codigoBanco;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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