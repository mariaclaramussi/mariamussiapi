package br.edu.infnet.agendamento.model.service;

import br.edu.infnet.agendamento.clients.BrasilApiFeignClients;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeriadoService {

    private final BrasilApiFeignClients brasilApiFeignClients;

    public FeriadoService(BrasilApiFeignClients brasilApiFeignClients) {
        this.brasilApiFeignClients = brasilApiFeignClients;
    }

    public List<BrasilApiFeignClients.Feriado> obterFeriados(String ano) {
        int parsedAno = Integer.parseInt(ano);

        if (parsedAno < 1900 || parsedAno > 2199) {
            throw new IllegalArgumentException("Ano deve estar entre 1900 e 2199.");
        }

        return brasilApiFeignClients.obterFeriadosPorAno(ano);
    }

}
