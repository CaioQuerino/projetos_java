package br.com.conta_bancaria.conta_bancaria.dto.responses.banco;

import br.com.conta_bancaria.conta_bancaria.models.ViaCep;

public class BancoResponse {
    private Long id;
    private String nome;
    private ViaCep endereco;
    private String telefone;
    private String cnpj;
    private String agencia;
    private String codigoBanco;

    public BancoResponse() {}

    public BancoResponse(Long id, String nome, ViaCep endereco, String telefone, 
                        String cnpj, String agencia, String codigoBanco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.agencia = agencia;
        this.codigoBanco = codigoBanco;
    }

    public Long getId() { return id; }
    
    public String getNome() { return nome; }
    
    public ViaCep getEndereco() { return endereco; }
    
    public String getTelefone() { return telefone; }
    
    public String getCnpj() { return cnpj; }
    
    public String getAgencia() { return agencia; }
    
    public String getCodigoBanco() { return codigoBanco; }
}