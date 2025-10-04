package br.edu.infnet.agendamento.dto;

import br.edu.infnet.agendamento.model.domain.Agendamento;
import br.edu.infnet.agendamento.model.domain.Medico;
import br.edu.infnet.agendamento.model.domain.Paciente;
import br.edu.infnet.agendamento.model.domain.TipoConsulta;

public class AgendamentoResponseDTO {

    private Integer prontuario;
    private String planoDeSaude;
    private TipoConsulta tipoConsulta;
    private double valor;
    private String data;
    private Paciente paciente;
    private Medico medico;


    public AgendamentoResponseDTO(Agendamento agendamento) {
        this.prontuario = agendamento.getProntuario();
        this.planoDeSaude = agendamento.getPlanoDeSaude();
        this.tipoConsulta = agendamento.getTipoConsulta();
        this.valor = agendamento.getValor();
        this.data = agendamento.getData();
        this.paciente = agendamento.getPaciente();
        this.medico = agendamento.getMedico();
    }

    public Integer getProntuario() {
        return prontuario;
    }

    public void setProntuario(Integer prontuario) {
        this.prontuario = prontuario;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
