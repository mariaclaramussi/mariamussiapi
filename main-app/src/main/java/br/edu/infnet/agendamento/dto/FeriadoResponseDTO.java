package br.edu.infnet.agendamento.dto;

import br.edu.infnet.agendamento.clients.BrasilApiFeignClients;

import java.time.LocalDate;

public class FeriadoResponseDTO {
    private LocalDate date;
    private String name;

    public FeriadoResponseDTO(BrasilApiFeignClients.Feriado feriado) {
        this.date = feriado.getDate();
        this.name = feriado.getName();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
