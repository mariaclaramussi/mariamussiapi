package br.edu.infnet.mariamussiapi.model.service;

import br.edu.infnet.mariamussiapi.model.domain.Agendamento;
import br.edu.infnet.mariamussiapi.model.domain.Paciente;
import br.edu.infnet.mariamussiapi.model.domain.exceptions.PacienteInvalidoException;
import br.edu.infnet.mariamussiapi.model.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements CrudService<Paciente, Integer>{

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
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
    public Paciente adicionar(Paciente paciente) {
        validar(paciente);
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente editar(Integer id, Paciente paciente) {
        validarId(id);
        validar(paciente);
        paciente.setId(id);

        return pacienteRepository.save(paciente);
    }

    @Override
    public void excluir(Integer id) {
        validarId(id);
        Paciente paciente = obterPorId(id);

        pacienteRepository.delete(paciente);
    }

    @Override
    public Paciente obterPorId(Integer id) {
        validarId(id);
        return  pacienteRepository.findById(id).orElseThrow(() -> new PacienteInvalidoException("Paciente nao encontrado"));
    }

    @Override
    public List<Paciente> obterLista() {
        return pacienteRepository.findAll();
    }

    public List<Agendamento> verificarConsultas(Integer id) {
        // TODO: verificar se existe consultas para o paciente
        return null;
    }
}
