package br.edu.infnet.mariamussiapi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Timestamp;

import br.edu.infnet.mariamussiapi.model.domain.Agendamento;
import br.edu.infnet.mariamussiapi.model.service.AgendamentoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AgendamentoLoader implements ApplicationRunner {

    private final AgendamentoService agendamentoService;

    public AgendamentoLoader(AgendamentoService agendamentoService) {this.agendamentoService = agendamentoService;}

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader arquivo = new FileReader("agendamentos.txt");
        BufferedReader leitura = new BufferedReader(arquivo);

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null) {

            campos = linha.split(";");

            Agendamento agendamento = new Agendamento();

            agendamento.setProntuario(Integer.valueOf(campos[2]));
            agendamento.setPlanoDeSaude(campos[3]);
            agendamento.setTipoConsulta(campos[4]);
            agendamento.setValor(Double.parseDouble(campos[5]));
            agendamento.setData(Timestamp.valueOf(campos[6]));

            agendamentoService.adicionar(agendamento);

            System.out.println(agendamento);

            linha = leitura.readLine();
        }

        System.out.println("- " + agendamentoService.obterLista().size());

        leitura.close();
    }
}