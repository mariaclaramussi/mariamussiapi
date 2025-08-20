package br.edu.infnet.mariamussiapi.model.service;

import br.edu.infnet.mariamussiapi.model.domain.Agendamento;
import br.edu.infnet.mariamussiapi.model.domain.Medico;
import br.edu.infnet.mariamussiapi.model.domain.Paciente;
import br.edu.infnet.mariamussiapi.model.domain.exceptions.PacienteInvalidoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PacienteService implements CrudService<Paciente, Integer>{

    private final Map<Integer, Paciente> mapa = new ConcurrentHashMap<Integer, Paciente>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    @Override
    public Paciente adicionar(Paciente paciente) {
        if(paciente.getCpf() == null) {
            throw new PacienteInvalidoException("O CPF é obrigatorio");
        }

        paciente.setId(nextId.getAndIncrement());
        mapa.put(paciente.getId(), paciente);

        return paciente;
    }

    @Override
    public Paciente editar(Integer integer, Paciente object) {
        return null;
    }

    @Override
    public void excluir(Integer integer) {

    }

    @Override
    public Paciente obterPorId(Integer integer) {
        return null;
    }

    @Override
    public List<Paciente> obterLista() {
        return new ArrayList<Paciente>(mapa.values());
    }

    public List<Agendamento> verificarConsultas(Integer id) {
        // TODO: verificar se existe consultas para o paciente
        return null;
    }
}
