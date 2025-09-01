package br.edu.infnet.mariamussiapi.model.repository;

import br.edu.infnet.mariamussiapi.model.domain.Agendamento;
import br.edu.infnet.mariamussiapi.model.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    Optional<Paciente> findByCpf(String cpf);

}
