package br.edu.infnet.mariamussiapi.model.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Paciente extends Pessoa {

    private String nomeMae;
    private boolean possuiPlano;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Agendamento> agendamentos = new ArrayList<Agendamento>();

    @Override
    public String toString() {
        return String.format(
                "Paciente {nome='%s', cpf='%s'}",
                getNome(),
                getCpf()
        );
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public boolean isPossuiPlano() {
        return possuiPlano;
    }

    public void setPossuiPlano(boolean possuiPlano) {
        this.possuiPlano = possuiPlano;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }


}
