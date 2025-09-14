package br.com.caioq.models;

public class Endereco {
    private int id;
    private String cep;
    private String rua;
    private String cidade;
    private int numero;
    private String complemento;

    public Endereco() {}

    public Endereco(int id, String cep, String rua, String cidade, int
                                            numero, String complemento) {
        this.id = id;
        this.cep = cep;
        this.rua = rua;
        this.cidade = cidade;
        this.numero = numero;
        this.complemento = complemento;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", cidade='" + cidade + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                '}';
    }
}