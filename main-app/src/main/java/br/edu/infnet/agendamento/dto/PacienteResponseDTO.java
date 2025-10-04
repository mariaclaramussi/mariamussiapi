package br.edu.infnet.agendamento.dto;



import br.edu.infnet.agendamento.model.domain.Agendamento;

import java.util.ArrayList;
import java.util.List;

public class PacienteResponseDTO {

    private String cpf;
    private String nome;
    private String nomeMae;
    private boolean possuiPlano;
    private List<Agendamento> agendamentos = new ArrayList<Agendamento>();
}
