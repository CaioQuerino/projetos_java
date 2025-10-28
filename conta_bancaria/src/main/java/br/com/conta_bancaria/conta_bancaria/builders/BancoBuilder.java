package br.com.conta_bancaria.conta_bancaria.builders;

import br.com.conta_bancaria.conta_bancaria.models.Banco;
import br.com.conta_bancaria.conta_bancaria.models.ViaCep;

public class BancoBuilder {
    
    private String nome;
    private ViaCep endereco;
    private String telefone;
    private String cnpj;
    private String agencia;
    private String codigoBanco;

    public BancoBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public BancoBuilder endereco(ViaCep endereco) {
        this.endereco = endereco;
        return this;
    }

    public BancoBuilder telefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public BancoBuilder cnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public BancoBuilder agencia(String agencia) {
        this.agencia = agencia;
        return this;
    }

    public BancoBuilder codigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
        return this;
    }

    public Banco build() {
        Banco banco = new Banco();
        banco.setNome(this.nome);
        banco.setEndereco(this.endereco);
        banco.setTelefone(this.telefone);
        banco.setCnpj(this.cnpj);
        banco.setAgencia(this.agencia);
        banco.setCodigoBanco(this.codigoBanco);
        return banco;
    }
}
