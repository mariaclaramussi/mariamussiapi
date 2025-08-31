package br.edu.infnet.mariamussiapi.model.repository;

import br.edu.infnet.mariamussiapi.model.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}
