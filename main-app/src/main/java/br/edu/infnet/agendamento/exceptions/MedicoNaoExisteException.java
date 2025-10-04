package br.edu.infnet.agendamento.exceptions;

public class MedicoNaoExisteException extends RuntimeException {
    public MedicoNaoExisteException(String message) {
        super(message);
    }
}
