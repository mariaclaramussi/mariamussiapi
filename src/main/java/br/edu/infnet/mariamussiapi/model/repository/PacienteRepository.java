package br.edu.infnet.mariamussiapi.model.repository;

import br.edu.infnet.mariamussiapi.model.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
