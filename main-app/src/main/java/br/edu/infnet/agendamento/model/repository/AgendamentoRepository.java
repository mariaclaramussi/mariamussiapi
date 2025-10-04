package br.edu.infnet.agendamento.model.repository;

import br.edu.infnet.agendamento.model.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
    Optional<Agendamento> findByData(String data);

    Optional<List<Agendamento>> findAllByMedicoId(Integer id);
    Optional<List<Agendamento>> findAllByPacienteId(Integer id);
}
