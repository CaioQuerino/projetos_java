package br.com.consumo_api_via_cep.models;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import br.com.consumo_api_via_cep.interfaces.IRepository;

public abstract class UsuarioDB implements IRepository {
    protected List<Object> registros = new ArrayList<>();
    protected int ultimoId = 0;
    
    @Override
    public String salvar(Object obj) {
        if (obj == null) {
            return "Erro: Objeto não pode ser nulo";
        }
        
        try {
            Field field = obj.getClass().getDeclaredField("id");
            field.setAccessible(true);
            int novoId = ++ultimoId;
            field.set(obj, novoId);
            
            registros.add(obj);
            return "Salvo com sucesso! ID: " + novoId;
        } catch (Exception e) {
            return "Erro ao salvar: " + e.getMessage();
        }
    }
    
    @Override
    public Object buscarPorId(int id) {
        for (Object obj : registros) {
            try {
                Field field = obj.getClass().getDeclaredField("id");
                field.setAccessible(true);
                int objId = (int) field.get(obj);
                
                if (objId == id) {
                    return obj;
                }
            } catch (Exception e) {
                continue;
            }
        }
        return null;
    }
    
    @Override
    public String atualizar(int id, Object obj) {
        if (obj == null) {
            return "Erro: Objeto não pode ser nulo";
        }
        
        for (int i = 0; i < registros.size(); i++) {
            try {
                Object registro = registros.get(i);
                Field field = registro.getClass().getDeclaredField("id");
                field.setAccessible(true);
                int registroId = (int) field.get(registro);
                
                if (registroId == id) {
                    registros.set(i, obj);
                    return "Atualizado com sucesso! ID: " + id;
                }
            } catch (Exception e) {
                continue;
            }
        }
        return "Erro: Registro não encontrado com ID: " + id;
    }
    
    @Override
    public String deletar(int id) {
        for (int i = 0; i < registros.size(); i++) {
            try {
                Object registro = registros.get(i);
                Field field = registro.getClass().getDeclaredField("id");
                field.setAccessible(true);
                int registroId = (int) field.get(registro);
                
                if (registroId == id) {
                    registros.remove(i);
                    return "Deletado com sucesso! ID: " + id;
                }
            } catch (Exception e) {
                continue;
            }
        }
        return "Erro: Registro não encontrado com ID: " + id;
    }
    
    public List<Object> listarTodos() {
        return new ArrayList<>(registros);
    }
    
    public int getTotalRegistros() {
        return registros.size();
    }
}