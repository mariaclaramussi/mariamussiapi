package br.edu.infnet.mariamussiapi.model.service;

import java.util.List;

public interface CrudService<T, ID> {

    T adicionar(T object);
    T editar(ID id, T object);
    void excluir(ID id);
    T obterPorId(ID id);
    List<T> obterLista();

}
