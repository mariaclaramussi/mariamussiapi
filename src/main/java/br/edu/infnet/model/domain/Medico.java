package br.edu.infnet.model.domain;

public class Medico extends Pessoa {
    private String CRM;
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
