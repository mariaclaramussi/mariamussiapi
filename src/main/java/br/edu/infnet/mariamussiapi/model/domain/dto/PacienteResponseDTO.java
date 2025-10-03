package br.edu.infnet.mariamussiapi.model.domain.dto;

import br.edu.infnet.mariamussiapi.model.domain.Agendamento;
import br.edu.infnet.mariamussiapi.model.domain.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PacienteResponseDTO extends Pessoa {

    private String cpf;
    private String nome;
    private String nomeMae;
    private boolean possuiPlano;
    private List<Agendamento> agendamentos = new ArrayList<Agendamento>();
}
