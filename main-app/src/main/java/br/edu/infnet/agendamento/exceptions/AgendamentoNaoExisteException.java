package br.edu.infnet.agendamento.exceptions;

public class AgendamentoNaoExisteException extends RuntimeException {

    public AgendamentoNaoExisteException(String mensagem) {
        super(mensagem);
    }
}
