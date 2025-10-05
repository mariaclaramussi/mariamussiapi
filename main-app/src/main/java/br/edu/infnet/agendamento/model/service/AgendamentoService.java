package br.edu.infnet.agendamento.model.service;


import br.edu.infnet.agendamento.clients.BrasilApiFeignClients;
import br.edu.infnet.agendamento.exceptions.AgendamentoInvalidoException;
import br.edu.infnet.agendamento.exceptions.AgendamentoNaoExisteException;
import br.edu.infnet.agendamento.model.domain.Agendamento;
import br.edu.infnet.agendamento.model.repository.AgendamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService implements CrudService<Agendamento, Integer> {

    private final AgendamentoRepository agendamentoRepository;
    private final BrasilApiFeignClients brasilApiFeignClients;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, BrasilApiFeignClients brasilApiFeignClients) {
        this.agendamentoRepository = agendamentoRepository;
        this.brasilApiFeignClients = brasilApiFeignClients;
    }

    private void validar(Agendamento agendamento) {
        if(agendamento == null) {
            throw new IllegalArgumentException("O agendamento não pode ser vazio");
        }

        if(agendamento.getPaciente() == null) {
            throw new AgendamentoInvalidoException("O paciente é obrigatório");
        } else if (agendamento.getMedico() == null) {
            throw new AgendamentoInvalidoException("O médico é obrigatório");
        }

        if(verificarFeriado(agendamento.getData())) {
            throw new AgendamentoInvalidoException("O agendamento nao pode ocorrer no feriado");
        }
    }

    public void validarId(Integer id) {
        if(id == null || id == 0) {
            throw new IllegalArgumentException("O ID nao pode ser nulo ou vazio");
        }
    }

    @Override
    @Transactional
    public Agendamento adicionar(Agendamento agendamento) {
        validar(agendamento);
        return agendamentoRepository.save(agendamento);
    }

    @Override
    @Transactional
    public Agendamento editar(Integer id, Agendamento agendamento) {
        validarId(id);
        validar(agendamento);

        obterPorId(id);
        agendamento.setId(id);

        return agendamentoRepository.save(agendamento);
    }

    @Override
    @Transactional
    public void excluir(Integer id) {
        validarId(id);
        Agendamento agendamento = obterPorId(id);

        agendamentoRepository.delete(agendamento);
    }

    @Override
    public Agendamento obterPorId(Integer id) {
        validarId(id);

        return agendamentoRepository.findById(id).orElseThrow(() -> new AgendamentoNaoExisteException("Agendamento nao encontrado"));
    }

    @Override
    public List<Agendamento> obterLista() {
        return agendamentoRepository.findAll();
    }

    public Boolean verificarAgendamento(String data) {
        Optional<Agendamento> agendamento = agendamentoRepository.findByData(data);

        return agendamento.isPresent();
    }

    private Boolean verificarFeriado(String data) {
        String[] str = data.split("/");
        List<BrasilApiFeignClients.Feriado> feriados = brasilApiFeignClients.obterFeriadosPorAno(str[2]);

        return feriados.stream().anyMatch(f -> f.getDate().isEqual(LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
    }
}
