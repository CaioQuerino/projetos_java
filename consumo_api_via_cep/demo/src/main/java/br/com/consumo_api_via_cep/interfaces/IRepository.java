package br.com.consumo_api_via_cep.interfaces;

public interface IRepository {
    String salvar(Object obj);
    String atualizar(int id, Object obj);
    String deletar(int id);
    Object buscarPorId(int id);
    Object[] buscarTodos();
}
