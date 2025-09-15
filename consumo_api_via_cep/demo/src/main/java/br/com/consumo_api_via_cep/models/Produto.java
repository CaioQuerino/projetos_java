package br.com.consumo_api_via_cep.models;

public class Produto extends Usuario {
    private double preco;
    private String descricao;
    private String categoria;
    private int quantidade;

    Produto() {}

    Produto(int id, String nome, double preco, String descricao, 
                                String categoria, int quantidade) {
        super(id, nome);
        this.preco = preco;
        this.descricao = descricao;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
