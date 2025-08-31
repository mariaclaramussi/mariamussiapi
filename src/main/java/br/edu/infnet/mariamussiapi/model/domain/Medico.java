package br.edu.infnet.mariamussiapi.model.domain;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Medico extends Pessoa {

    @NotBlank(message = "O CRM é obrigatório.")
    @Size(min = 6, max = 6, message = "O CRM deve conter 6 dígitos")
    private String CRM;

    @Size(min = 3, message = "A especialidade deve ter no minimo 3 caracteres")
    private String especialidade;

    @Override
    public String toString() {
        return "Medico {" +
                "CRM='" + CRM + '\'' +
                ", especialidade='" + especialidade + '\'' +
                '}';
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
}
