package br.com.conta_bancaria.conta_bancaria.models;

import br.com.conta_bancaria.conta_bancaria.interfaces.ViaCepDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "banco")


public class Banco implements ViaCepDto {
	private String nome;
	private ViaCepDto endereco;
	private String telefone;
	private String cnpj;
	private String agencia;
	private String codigoBanco;

	public Banco (
		String nome,
		ViaCepDto endereco,
		String telefone,
		String cnpj,
		String agencia,
		String codigoBanco
	) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cnpj = cnpj;
		this.agencia = agencia;
		this.codigoBanco = codigoBanco;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ViaCepDto getEndereco() {
		return endereco;
	}
	public void setEndereco(ViaCepDto endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getCodigoBanco() {
		return codigoBanco;
	}
	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public static Banco fromBanco(Banco banco) {
		return new Banco(
			banco.nome,
			banco.endereco,
			banco.telefone,
			banco.cnpj,
			banco.agencia,
			banco.codigoBanco
		);
	}
}
