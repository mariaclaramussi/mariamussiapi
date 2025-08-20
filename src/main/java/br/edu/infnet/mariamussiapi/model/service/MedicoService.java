package br.edu.infnet.mariamussiapi.model.service;

import br.edu.infnet.mariamussiapi.model.domain.Agendamento;
import br.edu.infnet.mariamussiapi.model.domain.Medico;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService implements CrudService<Medico, Integer> {
    @Override
    public Medico adicionar(Medico object) {
        return null;
    }

    @Override
    public Medico editar(Integer integer, Medico object) {
        return null;
    }

    @Override
    public void excluir(Integer integer) {

    }

    @Override
    public Medico obterPorId(Integer integer) {
        return null;
    }

    @Override
    public List<Medico> obterLista() {
        return List.of();
    }

    public List<Agendamento> verificarAgendamentos(Integer id) {
        // TODO: confirmar agendamentos no nome do medico
        return null;
    }
}
