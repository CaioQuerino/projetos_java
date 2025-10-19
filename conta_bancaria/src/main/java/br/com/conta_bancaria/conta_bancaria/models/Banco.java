package br.com.conta_bancaria.conta_bancaria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "banco")

public class Banco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @Embedded
    private ViaCep endereco;
    
    private String telefone;
    private String cnpj;
    private String agencia;
    private String codigoBanco;

    public Banco() {}

    public Banco(String nome, ViaCep endereco, String telefone, String cnpj, 
                                       String agencia, String codigoBanco) {

        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cnpj = cnpj;
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
	
    public String getCnpj() { return cnpj; }
	
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
	
    public String getAgencia() { return agencia; }
	
    public void setAgencia(String agencia) { this.agencia = agencia; }
	
    public String getCodigoBanco() { return codigoBanco; }
	
    public void setCodigoBanco(String codigoBancon) { this.codigoBanco = codigoBancon; }
}