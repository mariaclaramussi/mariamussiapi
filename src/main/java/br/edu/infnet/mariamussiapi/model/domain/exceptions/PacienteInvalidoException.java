package br.edu.infnet.mariamussiapi.model.domain.exceptions;

public class PacienteInvalidoException extends RuntimeException {

    public PacienteInvalidoException(String message) {
        super(message);
    }
}
