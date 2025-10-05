package br.edu.infnet.agendamento.mappers;

import br.edu.infnet.agendamento.dto.AgendamentoRequestDTO;
import br.edu.infnet.agendamento.dto.AgendamentoResponseDTO;
import br.edu.infnet.agendamento.model.domain.Agendamento;
import br.edu.infnet.agendamento.model.domain.Medico;
import br.edu.infnet.agendamento.model.domain.Paciente;

public class AgendamentoMapper {

    public static Agendamento toEntity(AgendamentoRequestDTO request, Paciente paciente, Medico medico) {
        if (request == null) return null;

       Agendamento agendamento = new Agendamento();
       agendamento.setData(request.getData());
       agendamento.setPlanoDeSaude(request.getPlanoDeSaude());
       agendamento.setProntuario(request.getProntuario());
       agendamento.setTipoConsulta(request.getTipoConsulta());
       agendamento.setValor(request.getValor());
       agendamento.setPaciente(paciente);
       agendamento.setMedico(medico);
       return agendamento;
    }

    public static AgendamentoResponseDTO toDTO(Agendamento agendamento) {
        return new AgendamentoResponseDTO(agendamento);
    }
}
