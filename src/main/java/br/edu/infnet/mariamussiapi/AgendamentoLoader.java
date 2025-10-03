package br.edu.infnet.mariamussiapi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Timestamp;

import br.edu.infnet.mariamussiapi.model.domain.Agendamento;
import br.edu.infnet.mariamussiapi.model.domain.Medico;
import br.edu.infnet.mariamussiapi.model.domain.Paciente;
import br.edu.infnet.mariamussiapi.model.domain.TipoConsulta;
import br.edu.infnet.mariamussiapi.model.domain.exceptions.MedicoNaoExisteException;
import br.edu.infnet.mariamussiapi.model.domain.exceptions.PacienteInvalidoException;
import br.edu.infnet.mariamussiapi.model.service.AgendamentoService;
import br.edu.infnet.mariamussiapi.model.service.MedicoService;
import br.edu.infnet.mariamussiapi.model.service.PacienteService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Component
public class AgendamentoLoader implements ApplicationRunner {

    private final AgendamentoService agendamentoService;
    private final MedicoService medicoService;
    private final PacienteService pacienteService;

    public AgendamentoLoader(AgendamentoService agendamentoService, MedicoService medicoService, PacienteService pacienteService) {
        this.agendamentoService = agendamentoService;
        this.medicoService = medicoService;
        this.pacienteService = pacienteService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader arquivo = new FileReader("agendamentos.txt");
        BufferedReader leitura = new BufferedReader(arquivo);

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null) {

            campos = linha.split(";");

            Paciente paciente = null;
            try {
                paciente = pacienteService.obterPorCpf(campos[5]);
            } catch (PacienteInvalidoException e) {
                linha = leitura.readLine();
                continue;
            }

            Medico medico = null;
            try {
                medico = medicoService.obterPorCrm(campos[6]);
            } catch (MedicoNaoExisteException e) {
                linha = leitura.readLine();
                continue;
            }

            Agendamento agendamento = new Agendamento();
            agendamento.setPaciente(paciente);
            agendamento.setMedico(medico);
            agendamento.setProntuario(Integer.valueOf(campos[0]));
            agendamento.setPlanoDeSaude(campos[1]);
            agendamento.setTipoConsulta(TipoConsulta.valueOf(campos[2]));
            agendamento.setValor(Double.parseDouble(campos[3]));
            agendamento.setData(campos[4]);

            try {
                agendamentoService.adicionar(agendamento);
                System.out.println("  [OK] Agendamento " + agendamento.getProntuario() + " incluído com sucesso.");
            } catch (Exception e) {
                System.err.println("  [ERRO] Problema na inclusão do agendamento " + agendamento.getProntuario() + ": " + e.getMessage());
            }
            linha = leitura.readLine();
        }

        System.out.println("----AGENDAMENTOS-----");
        agendamentoService.obterLista().forEach(System.out::println);
        System.out.println("-----------------------------");
        leitura.close();
    }
}