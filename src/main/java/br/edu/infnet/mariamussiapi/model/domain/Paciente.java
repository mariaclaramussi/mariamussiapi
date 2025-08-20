package br.edu.infnet.mariamussiapi.model.domain;

public class Paciente extends Pessoa {

    private String nomeMae;
    private boolean possuiPlano;

    @Override
    public String toString() {
        return "Paciente{" +
                "nomeMae='" + nomeMae + '\'' +
                ", possuiPlano=" + possuiPlano +
                '}';
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
}
