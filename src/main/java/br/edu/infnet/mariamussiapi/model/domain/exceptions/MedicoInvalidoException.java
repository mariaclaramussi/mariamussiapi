package br.edu.infnet.mariamussiapi.model.domain.exceptions;

public class MedicoInvalidoException extends RuntimeException{
    public MedicoInvalidoException(String message) {
        super(message);
    }
}
