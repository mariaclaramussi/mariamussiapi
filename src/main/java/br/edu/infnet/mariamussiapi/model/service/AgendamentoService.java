package br.edu.infnet.mariamussiapi.model.service;

import br.edu.infnet.mariamussiapi.model.domain.Agendamento;
import br.edu.infnet.mariamussiapi.model.domain.exceptions.AgendamentoInvalidoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AgendamentoService implements CrudService<Agendamento, Integer> {

    private final Map<Integer, Agendamento> mapa = new ConcurrentHashMap<Integer, Agendamento>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    private void validar(Agendamento agendamento) {
        if(agendamento == null) {
            throw new IllegalArgumentException("O agendamento não pode ser vazio");
        }
    }

    @Override
    public Agendamento adicionar(Agendamento agendamento) {

        if(agendamento.getPaciente() == null) {
            throw new AgendamentoInvalidoException("O paciente é obrigatório");
        } else if (agendamento.getMedico() == null) {
            throw new AgendamentoInvalidoException("O médico é obrigatório");
        }

        agendamento.setId(nextId.getAndIncrement());
        mapa.put(agendamento.getId(), agendamento);

        return agendamento;
    }

    @Override
    public Agendamento editar(Integer id, Agendamento agendamento) {
        if(id == null || id == 0) {
            throw new IllegalArgumentException("O ID nao pode ser nulo ou vazio");
        }

        validar(agendamento);

        obterPorId(id);

        agendamento.setId(id);
        mapa.put(agendamento.getId(), agendamento);

        return agendamento;
    }

    @Override
    public void excluir(Integer id) {
        mapa.remove(id);
    }

    @Override
    public Agendamento obterPorId(Integer id) {
        Agendamento agendamento = mapa.get(id);

        if(agendamento == null) {
            throw new AgendamentoInvalidoException("Agendamento nao existe. ID:" + id);
        }

        return agendamento;
    }

    @Override
    public List<Agendamento> obterLista() {
        return new ArrayList<Agendamento>(mapa.values());
    }

    public Boolean verificarAgendamento(Integer id) {
        // TODO: verificar se ja foi realizado
        return false;
    }
}
