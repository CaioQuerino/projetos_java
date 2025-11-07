package br.com.conta_bancaria.conta_bancaria.interfaces;

import br.com.conta_bancaria.conta_bancaria.models.ViaCep;

/**
 * Interface que define o contrato para requisições relacionadas à entidade Banco.
 * Permite reutilizar a mesma estrutura para criação e atualização.
 */
public interface BancoRequest {
    /**
     * Nome do banco.
     * @return nome da instituição bancária
     */
    String getNome();

    /**
     * Endereço do banco (objeto ViaCep).
     * @return endereço completo com informações de CEP
     */
    ViaCep getEndereco();

    /**
     * Telefone de contato do banco.
     * @return número de telefone
     */
    String getTelefone();

    /**
     * CNPJ do banco.
     * @return CNPJ da instituição
     */
    String getCnpj();

    /**
     * Código da agência bancária.
     * @return número da agência
     */
    String getAgencia();

    /**
     * Código identificador do banco.
     * @return código do banco (ex: 001, 104, 341)
     */
    String getCodigoBanco();
}