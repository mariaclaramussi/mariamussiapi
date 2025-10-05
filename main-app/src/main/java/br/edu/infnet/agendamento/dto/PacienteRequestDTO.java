package br.edu.infnet.agendamento.dto;

public class PacienteRequestDTO {

    private String nome;
    private String nomeMae;
    private String nascimento;
    private String sexo;
    private String cpf;
    private String cep;
    private boolean possuiPlano;

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setPossuiPlano(boolean possuiPlano) {
        this.possuiPlano = possuiPlano;
    }

    public boolean isPossuiPlano() {
        return possuiPlano;
    }
}
