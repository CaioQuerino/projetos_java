package br.com.conta_bancaria.conta_bancaria.builders;

import br.com.conta_bancaria.conta_bancaria.models.ViaCep;
import br.com.conta_bancaria.conta_bancaria.models.Cliente;

public class ClienteBuilder {
    private String nome;
    private ViaCep endereco;
    private String telefone;
    private String cpf;
    private String agencia;
    private String codigoBanco;

    public ClienteBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public ClienteBuilder endereco(ViaCep endereco) {
        this.endereco = endereco;
        return this;
    }

    public ClienteBuilder telefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public ClienteBuilder cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public ClienteBuilder agencia(String agencia) {
        this.agencia = agencia;
        return this;
    }

    public ClienteBuilder codigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
        return this;
    }

    public Cliente build() {
        Cliente cliente = new Cliente();
        cliente.setNome(this.nome);
        cliente.setEndereco(this.endereco);
        cliente.setTelefone(this.telefone);
        cliente.setCpf(this.cpf);
        cliente.setAgencia(this.agencia);
        cliente.setCodigoBanco(this.codigoBanco);
        return cliente;
    }
}
