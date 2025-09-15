package br.com.consumo_api_via_cep.interfaces;

public interface IRepository {
    abstract String salvar(Object obj);
    abstract String atualizar(int id, Object obj);
    abstract String deletar(int id);
    abstract Object buscarPorId(int id);
    abstract Object[] buscarTodos();
}
