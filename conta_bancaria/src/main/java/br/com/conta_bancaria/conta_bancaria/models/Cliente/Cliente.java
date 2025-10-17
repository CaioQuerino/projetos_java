package br.com.conta_bancaria.conta_bancaria.models;

import br.com.conta_bancaria.conta_bancaria.interfaces.ViaCepDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")

public class Cliente {
    private String nome;
    private ViaCepDto endereco;
    private String telefone;
    private String cpf;
    private String agencia;
    private String codigoBanco;


    public Cliente(String nome, ViaCepDto endereco, String telefone, String cpf, 
                                          String agencia, String codigoBanco) {

        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.agencia = agencia;
        this.codigoBanco = codigoBanco;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public ViaCepDto getEndereco() { return endereco; }
    public void setEndereco(ViaCepDto endereco) { this.endereco = endereco; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getAgencia() { return agencia; }
    public void setAgencia(String agencia) { this.agencia = agencia; }

    public String getCodigoBanco() { return codigoBanco; }
    public void setCodigoBanco(String codigoBanco) { this.codigoBanco = codigoBanco; }

    /**
     *
     * @param nome
     * @param endereco
     * @param telefone
     * @param cpf
     * @param agencia
     * @param codigoBanco
     * @return
     */

    // Não tem API (Dados mockados)
    public static Cliente fromCliente(String nome, ViaCepDto endereco, 
        String telefone, String cpf, String agencia, String codigoBanco) {
        
        return new Cliente(nome, endereco, telefone, cpf, agencia, codigoBanco);
    }
}
