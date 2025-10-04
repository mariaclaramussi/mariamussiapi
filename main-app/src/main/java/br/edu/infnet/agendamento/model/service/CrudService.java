package br.edu.infnet.agendamento.model.service;

import java.util.List;

public interface CrudService<T, ID> {

    T adicionar(T object);
    T editar(ID id, T object);
    void excluir(ID id);
    T obterPorId(ID id);
    List<T> obterLista();

}
