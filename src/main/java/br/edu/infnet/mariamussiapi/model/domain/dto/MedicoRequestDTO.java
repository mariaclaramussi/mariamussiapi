package br.edu.infnet.mariamussiapi.model.domain.dto;

import br.edu.infnet.mariamussiapi.model.domain.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MedicoRequestDTO extends Pessoa {

    @NotBlank(message = "O CRM é obrigatório.")
    @Size(min = 6, max = 6, message = "O CRM deve conter 6 dígitos")
    private String CRM;

    @Size(min = 3, message = "A especialidade deve ter no minimo 3 caracteres")
    private String especialidade;

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
