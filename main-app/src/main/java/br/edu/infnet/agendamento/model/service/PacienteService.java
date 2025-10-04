package br.edu.infnet.agendamento.model.service;


import br.edu.infnet.agendamento.exceptions.PacienteInvalidoException;
import br.edu.infnet.agendamento.model.domain.Agendamento;
import br.edu.infnet.agendamento.model.domain.Paciente;
import br.edu.infnet.agendamento.model.repository.AgendamentoRepository;
import br.edu.infnet.agendamento.model.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements CrudService<Paciente, Integer> {

    private final PacienteRepository pacienteRepository;
    private final AgendamentoRepository agendamentoRepository;

    public PacienteService(PacienteRepository pacienteRepository, AgendamentoRepository agendamentoRepository) {
        this.pacienteRepository = pacienteRepository;
        this.agendamentoRepository = agendamentoRepository;
    }

    public void validarId(Integer id) {
        if(id == null || id <= 0) {
            throw new IllegalArgumentException("O ID não pode ser nulo/zero!");
        }
    }

    public void validar(Paciente paciente) {
        if(paciente == null) {
            throw new IllegalArgumentException("O paciente não pode ser vazio");
        }

        if(paciente.getCpf() == null) {
            throw new PacienteInvalidoException("O CPF é obrigatorio");
        }
    }

    @Override
    @Transactional
    public Paciente adicionar(Paciente paciente) {
        validar(paciente);
        return pacienteRepository.save(paciente);
    }

    @Override
    @Transactional
    public Paciente editar(Integer id, Paciente paciente) {
        validarId(id);
        validar(paciente);
        paciente.setId(id);

        return pacienteRepository.save(paciente);
    }

    @Override
    @Transactional
    public void excluir(Integer id) {
        validarId(id);
        Paciente paciente = obterPorId(id);

        pacienteRepository.delete(paciente);
    }

    @Override
    public Paciente obterPorId(Integer id) {
        validarId(id);
        return pacienteRepository.findById(id).orElseThrow(() -> new PacienteInvalidoException("Paciente nao encontrado"));
    }

    @Override
    public List<Paciente> obterLista() {
        return pacienteRepository.findAll();
    }

    public Optional<List<Agendamento>> verificarConsultas(Integer id) {
        Optional<List<Agendamento>> agendamentos = agendamentoRepository.findAllByPacienteId(id);

        if(agendamentos.isPresent()) {
            return agendamentos;
        }
        return null;
    }

    public Paciente obterPorCpf(String cpf) {
        return pacienteRepository.findByCpf(cpf).orElseThrow(() -> new PacienteInvalidoException("Paciente nao encontrado"));
    }
}
