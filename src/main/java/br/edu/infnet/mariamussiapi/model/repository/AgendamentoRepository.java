package br.edu.infnet.mariamussiapi.model.repository;

import br.edu.infnet.mariamussiapi.model.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
}
