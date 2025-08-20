package br.edu.infnet.mariamussiapi.model.service;

import br.edu.infnet.mariamussiapi.model.domain.Agendamento;
import br.edu.infnet.mariamussiapi.model.domain.Medico;
import br.edu.infnet.mariamussiapi.model.domain.exceptions.MedicoInvalidoException;
import br.edu.infnet.mariamussiapi.model.domain.exceptions.MedicoNaoExisteException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MedicoService implements CrudService<Medico, Integer> {

    private final Map<Integer, Medico> mapa = new ConcurrentHashMap<Integer, Medico>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    @Override
    public Medico adicionar(Medico medico) {

        if(medico.getCRM() == null) {
            throw new MedicoInvalidoException("O CRM é obrigatorio");
        } else if (medico.getEspecialidade() == null) {
            throw new MedicoInvalidoException("Especialidade é obrigatorio");
        } else if (medico.getCRM().length() < 6) {
            throw new MedicoInvalidoException("CRM incorreto");
        }

        medico.setId(nextId.getAndIncrement());
        mapa.put(medico.getId(), medico);

        return medico;
    }

    @Override
    public Medico editar(Integer integer, Medico object) {
        return null;
    }

    @Override
    public void excluir(Integer integer) {

    }

    @Override
    public Medico obterPorId(Integer id) {
        Medico medico = mapa.get(id);

        if(medico == null) {
            throw new MedicoNaoExisteException("Medico nao existe");
        }

        return mapa.get(id);
    }

    @Override
    public List<Medico> obterLista() {
        return new ArrayList<Medico>(mapa.values());
    }

    public List<Agendamento> verificarAgendamentos(Integer id) {
        // TODO: confirmar agendamentos no nome do medico
        return null;
    }
}
