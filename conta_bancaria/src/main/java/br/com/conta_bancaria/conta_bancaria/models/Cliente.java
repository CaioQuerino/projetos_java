package br.com.conta_bancaria.conta_bancaria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @Embedded
    private ViaCep endereco;
    
    private String telefone;
    private String cpf;
    private String agencia;
    private String codigoBanco;

    public Cliente() {}

    public Cliente(String nome, ViaCep endereco, String telefone, String cpf, 
                                        String agencia, String codigoBanco) {

        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.agencia = agencia;
        this.codigoBanco = codigoBanco;
    }

    public Long getId() { return id; }
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