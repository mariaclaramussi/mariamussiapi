package br.edu.infnet.mariamussiapi.model.service;

import br.edu.infnet.mariamussiapi.model.domain.Agendamento;
import br.edu.infnet.mariamussiapi.model.domain.exceptions.AgendamentoInvalidoException;
import br.edu.infnet.mariamussiapi.model.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService implements CrudService<Agendamento, Integer> {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    private void validar(Agendamento agendamento) {
        if(agendamento == null) {
            throw new IllegalArgumentException("O agendamento não pode ser vazio");
        }

//        if(agendamento.getPaciente() == null) {
//            throw new AgendamentoInvalidoException("O paciente é obrigatório");
//        } else if (agendamento.getMedico() == null) {
//            throw new AgendamentoInvalidoException("O médico é obrigatório");
//        }
    }

    public void validarId(Integer id) {
        if(id == null || id == 0) {
            throw new IllegalArgumentException("O ID nao pode ser nulo ou vazio");
        }
    }

    @Override
    public Agendamento adicionar(Agendamento agendamento) {
        validar(agendamento);
        return agendamentoRepository.save(agendamento);
    }

    @Override
    public Agendamento editar(Integer id, Agendamento agendamento) {
        validarId(id);
        validar(agendamento);

        obterPorId(id);
        agendamento.setId(id);

        return agendamentoRepository.save(agendamento);
    }

    @Override
    public void excluir(Integer id) {
        validarId(id);
        Agendamento agendamento = obterPorId(id);

        agendamentoRepository.delete(agendamento);
    }

    @Override
    public Agendamento obterPorId(Integer id) {
        validarId(id);

        return agendamentoRepository.findById(id).orElseThrow(() -> new AgendamentoInvalidoException("Agendamento inválido"));
    }

    @Override
    public List<Agendamento> obterLista() {
        return agendamentoRepository.findAll();
    }

    public Boolean verificarAgendamento(Integer id) {
        validarId(id);
        return false;
    }
}
