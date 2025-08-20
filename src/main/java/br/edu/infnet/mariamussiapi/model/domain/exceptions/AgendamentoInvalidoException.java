package br.edu.infnet.mariamussiapi.model.domain.exceptions;

public class AgendamentoInvalidoException extends RuntimeException {

    public AgendamentoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
