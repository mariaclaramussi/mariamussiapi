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

    public MedicoResponseDTO(Medico medico) {
        this.CRM = medico.getCRM();
        this.especialidade = medico.getEspecialidade();
        this.agendamentos = medico.getAgendamentos();
        this.endereco = (new EnderecoResponseDTO(medico.getEndereco()));
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
