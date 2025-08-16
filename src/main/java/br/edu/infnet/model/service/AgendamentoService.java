package br.edu.infnet.model.service;

import br.edu.infnet.model.domain.Agendamento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AgendamentoService implements  CrudService<Agendamento, Integer> {

    private final Map<Integer, Agendamento> mapa = new ConcurrentHashMap<Integer, Agendamento>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    @Override
    public Agendamento adicionar(Agendamento agendamento) {
        agendamento.setId(nextId.getAndIncrement());
        mapa.put(agendamento.getId(), agendamento);

        return agendamento;
    }

    @Override
    public Agendamento editar(Integer integer) {
        return null;
    }

    @Override
    public void excluir(Integer id) {
        mapa.remove(id);
    }

    @Override
    public Agendamento obterPorId(Integer integer) {
        return null;
    }

    @Override
    public List<Agendamento> obterLista() {
        return new ArrayList<Agendamento>(mapa.values());
    }
}
