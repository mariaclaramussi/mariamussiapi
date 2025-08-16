package br.edu.infnet.model.service;

import java.util.List;

public interface CrudService<T, ID> {

    T adicionar(T object);
    T editar(ID id);
    void excluir(ID id);
    T obterPorId(ID id);
    List<T> obterLista();

}
