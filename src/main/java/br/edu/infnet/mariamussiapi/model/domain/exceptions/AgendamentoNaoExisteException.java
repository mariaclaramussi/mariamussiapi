package br.edu.infnet.mariamussiapi.model.domain.exceptions;

public class AgendamentoNaoExisteException extends RuntimeException {

    public AgendamentoNaoExisteException(String mensagem) {
        super(mensagem);
    }
}
