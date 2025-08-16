package br.edu.infnet.mariamussiapi.model.domain;

import java.sql.Timestamp;

public class Agendamento {

    private Integer id;

    private Paciente paciente;
    private Medico medico;
    private int prontuario;
    private String planoDeSaude;
    private String tipoConsulta; /* particular ou plano*/
    private double valor;
    private Timestamp data;

    @Override
    public String toString() {
        return "Agendamento {" +
                "id=" + id +
                ", paciente=" + paciente +
                ", medico=" + medico +
                ", prontuario=" + prontuario +
                ", planoDeSaude='" + planoDeSaude + '\'' +
                ", tipoConsulta='" + tipoConsulta + '\'' +
                ", valor=" + valor +
                ", data=" + data +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
