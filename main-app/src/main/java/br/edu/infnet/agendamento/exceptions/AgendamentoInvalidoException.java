package br.edu.infnet.agendamento.exceptions;

public class AgendamentoInvalidoException extends RuntimeException {

    public AgendamentoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
