package br.edu.infnet.agendamento.model.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Medico extends Pessoa {

    @NotBlank(message = "O CRM é obrigatório.")
    @Size(min = 6, max = 6, message = "O CRM deve conter 6 dígitos")
    private String CRM;

    @Size(min = 3, message = "A especialidade deve ter no minimo 3 caracteres")
    private String especialidade;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Agendamento> agendamentos = new ArrayList<Agendamento>();

    @Override
    public String toString() {
        return String.format(
                "Medico {nome='%s', crm='%s'}",
                getNome(),
                getCRM()
        );
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

}
