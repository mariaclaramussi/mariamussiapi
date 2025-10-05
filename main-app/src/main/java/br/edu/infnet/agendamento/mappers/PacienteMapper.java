package br.edu.infnet.agendamento.mappers;

import br.edu.infnet.agendamento.dto.PacienteRequestDTO;
import br.edu.infnet.agendamento.dto.PacienteResponseDTO;
import br.edu.infnet.agendamento.model.domain.Endereco;
import br.edu.infnet.agendamento.model.domain.Paciente;

public class PacienteMapper {

    public static Paciente toEntity(PacienteRequestDTO request, Endereco endereco) {
        if (request == null) return null;

        Paciente paciente = new Paciente();
        paciente.setPossuiPlano(request.isPossuiPlano());
        paciente.setNomeMae(request.getNomeMae());
        paciente.setCpf(request.getCpf());
        paciente.setNome(request.getNome());
        paciente.setNascimento(request.getNascimento());
        paciente.setEndereco(endereco);
        paciente.setSexo(request.getSexo());
        return paciente;
    }

    public static PacienteResponseDTO toDTO(Paciente paciente) {
        return new PacienteResponseDTO(paciente);
    }
}
