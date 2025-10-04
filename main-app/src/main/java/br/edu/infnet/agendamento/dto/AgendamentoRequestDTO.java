package br.edu.infnet.agendamento.dto;

import br.edu.infnet.agendamento.model.domain.TipoConsulta;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AgendamentoRequestDTO {

    @NotNull
    @Min(value = 6, message = "O prontuário deve conter 6 dígitos")
    private Integer prontuario;
    @NotBlank(message = "A data do agendamento é obrigatória.")
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$", message = "A data do agendamento deve estar no formato DD/MM/AAAA")
    private String data;
    @NotNull
    private Integer pacienteId;
    @NotNull
    private Integer medicoId;
    private String planoDeSaude;
    private TipoConsulta tipoConsulta;

    public Integer getProntuario() {
        return prontuario;
    }

    public void setProntuario(Integer prontuario) {
        this.prontuario = prontuario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Integer pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Integer getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Integer medicoId) {
        this.medicoId = medicoId;
    }

    public String getPlanoDeSaude() {
        return planoDeSaude;
    }

    public void setPlanoDeSaude(String planoDeSaude) {
        this.planoDeSaude = planoDeSaude;
    }

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
}
