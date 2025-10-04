package br.edu.infnet.agendamento.model.repository;

import br.edu.infnet.agendamento.model.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    Optional<Medico> findByCRM(String crm);
}
