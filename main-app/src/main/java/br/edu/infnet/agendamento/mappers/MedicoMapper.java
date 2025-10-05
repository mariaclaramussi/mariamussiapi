package br.edu.infnet.agendamento.mappers;

import br.edu.infnet.agendamento.dto.AgendamentoRequestDTO;
import br.edu.infnet.agendamento.dto.AgendamentoResponseDTO;
import br.edu.infnet.agendamento.dto.MedicoRequestDTO;
import br.edu.infnet.agendamento.dto.MedicoResponseDTO;
import br.edu.infnet.agendamento.model.domain.Agendamento;
import br.edu.infnet.agendamento.model.domain.Endereco;
import br.edu.infnet.agendamento.model.domain.Medico;
import br.edu.infnet.agendamento.model.domain.Paciente;

public class MedicoMapper {

    public static Medico toEntity(MedicoRequestDTO request, Endereco endereco) {
        if (request == null) return null;

        Medico medico = new Medico();
        medico.setCRM(request.getCRM());
        medico.setEspecialidade(request.getEspecialidade());
        medico.setCpf(request.getCpf());
        medico.setNome(request.getNome());
        medico.setNascimento(request.getNascimento());
        medico.setEndereco(endereco);
        medico.setSexo(request.getSexo());
        return medico;
    }

    public static MedicoResponseDTO toDTO(Medico Medico) {
        return new MedicoResponseDTO(Medico);
    }
}
