package br.edu.infnet.mariamussiapi.model.domain.exceptions;

public class MedicoNaoExisteException extends RuntimeException {
    public MedicoNaoExisteException(String message) {
        super(message);
    }
}
