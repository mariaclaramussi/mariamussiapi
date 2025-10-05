package br.edu.infnet.agendamento.dto;

import br.edu.infnet.agendamento.model.domain.Agendamento;
import br.edu.infnet.agendamento.model.domain.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteResponseDTO {

    private Integer id;
    private String nome;
    private String nascimento;
    private String sexo;
    private String cpf;
    private EnderecoResponseDTO endereco;;
    private String nomeMae;
    private boolean possuiPlano;
    private List<Agendamento> agendamentos = new ArrayList<Agendamento>();

    public PacienteResponseDTO(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.nascimento = paciente.getNascimento();
        this.sexo = paciente.getSexo();
        this.cpf = paciente.getCpf();
        this.endereco = new EnderecoResponseDTO(paciente.getEndereco());
        this.nomeMae = paciente.getNomeMae();
        this.agendamentos = paciente.getAgendamentos();
        this.possuiPlano = paciente.isPossuiPlano();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public EnderecoResponseDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoResponseDTO endereco) {
        this.endereco = endereco;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public boolean isPossuiPlano() {
        return possuiPlano;
    }

    public void setPossuiPlano(boolean possuiPlano) {
        this.possuiPlano = possuiPlano;
    }
}
