package br.edu.infnet.agendamento.dto;


import br.edu.infnet.agendamento.model.domain.Agendamento;
import br.edu.infnet.agendamento.model.domain.Medico;

import java.util.ArrayList;
import java.util.List;

public class MedicoResponseDTO {

    private String nome;
    private String CRM;
    private String especialidade;
    private List<Agendamento> agendamentos = new ArrayList<Agendamento>();
    private EnderecoResponseDTO endereco;
    private String cpf;
    private String sexo;
    private String nascimento;

    public MedicoResponseDTO(Medico medico) {
        this.CRM = medico.getCRM();
        this.especialidade = medico.getEspecialidade();
        this.agendamentos = medico.getAgendamentos();
        this.nome = medico.getNome();
        this.cpf = medico.getCpf();
        this.sexo = medico.getSexo();
        this.nascimento = medico.getNascimento();
        this.endereco = new EnderecoResponseDTO(medico.getEndereco());
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public EnderecoResponseDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoResponseDTO endereco) {
        this.endereco = endereco;
    }
}
