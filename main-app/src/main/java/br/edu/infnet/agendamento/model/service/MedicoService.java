package br.edu.infnet.agendamento.model.service;


import br.edu.infnet.agendamento.exceptions.MedicoInvalidoException;
import br.edu.infnet.agendamento.exceptions.MedicoNaoExisteException;
import br.edu.infnet.agendamento.model.domain.Agendamento;
import br.edu.infnet.agendamento.model.domain.Medico;
import br.edu.infnet.agendamento.model.repository.AgendamentoRepository;
import br.edu.infnet.agendamento.model.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService implements CrudService<Medico, Integer> {

    private final MedicoRepository medicoRepository;
    private final AgendamentoRepository agendamentoRepository;

    public MedicoService(MedicoRepository medicoRepository, AgendamentoRepository agendamentoRepository) {
        this.medicoRepository = medicoRepository;
        this.agendamentoRepository = agendamentoRepository;
    }

    public void validar(Medico medico) {
        if(medico.getCRM() == null) {
            throw new MedicoInvalidoException("O CRM é obrigatorio");
        } else if (medico.getEspecialidade() == null) {
            throw new MedicoInvalidoException("Especialidade é obrigatorio");
        } else if (medico.getCRM().length() < 6) {
            throw new MedicoInvalidoException("CRM incorreto");
        }
    }

    public void validarId(Integer id) {
        if(id == null || id == 0) {
            throw new IllegalArgumentException("O ID nao pode ser nulo ou vazio");
        }
    }

    @Override
    @Transactional
    public Medico adicionar(Medico medico) {
        validar(medico);

        return medicoRepository.save(medico);
    }

    @Override
    @Transactional
    public Medico editar(Integer id, Medico medico) {
        validarId(id);
        validar(medico);

        obterPorId(id);
        medico.setId(id);

        return medicoRepository.save(medico);
    }

    @Override
    @Transactional
    public void excluir(Integer id) {
        validarId(id);
        Medico medico = obterPorId(id);

        medicoRepository.delete(medico);
    }

    @Override
    public Medico obterPorId(Integer id) {
        validarId(id);

        return medicoRepository.findById(id).orElseThrow(() -> new MedicoNaoExisteException("Nao foi possivel encontrar médico"));
    }

    @Override
    public List<Medico> obterLista() {
        return medicoRepository.findAll();
    }

    public Optional<List<Agendamento>> verificarAgendamentos(Integer id) {
        Optional<List<Agendamento>> agendamentos = agendamentoRepository.findAllByMedicoId(id);

        if(agendamentos.isPresent()) {
            return agendamentos;
        }
        return null;
    }

    public Medico obterPorCrm(String crm) {
        return medicoRepository.findByCRM(crm).orElseThrow(() -> new MedicoNaoExisteException("Nao foi possivel encontrar médico"));
    }

}
