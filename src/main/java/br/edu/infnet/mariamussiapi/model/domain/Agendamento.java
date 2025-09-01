package br.edu.infnet.mariamussiapi.model.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Min(value = 6, message = "O prontuário deve conter 6 dígitos")
    private Integer prontuario;

    private String planoDeSaude;

    private String tipoConsulta; /* particular ou plano*/

    @Min(value = 0)
    private double valor;

    @NotBlank(message = "A data do agendamento é obrigatória.")
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$", message = "A data do agendamento deve estar no formato DD/MM/AAAA")
    private String data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @Override
    public String toString() {
        return String.format(
                "Agendamento {id=%d, prontuario='%s', data='%s', paciente=%s, medico=%s}",
                id,
                prontuario,
                data,
                paciente != null ? String.format("%d - %s", paciente.getId(), paciente.getNome()) : "N/A",
                medico != null ? String.format("%d - %s", medico.getId(), medico.getNome()) : "N/A"
        );
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
