package br.edu.infnet.mariamussiapi;

import br.edu.infnet.mariamussiapi.model.domain.Paciente;
import br.edu.infnet.mariamussiapi.model.service.PacienteService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;

@Component
public class PacienteLoader implements ApplicationRunner {
    private final PacienteService pacienteService;

    public PacienteLoader(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader arquivo = new FileReader("pacientes.txt");
        BufferedReader leitura = new BufferedReader(arquivo);

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null) {
            campos = linha.split(";");

            Paciente paciente = new Paciente();
            paciente.setNome(campos[0]);
            paciente.setCpf(campos[1]);
            paciente.setNomeMae(campos[2]);
            paciente.setPossuiPlano(Boolean.valueOf(campos[3]));
            paciente.setNascimento(campos[4]);

            pacienteService.adicionar(paciente);

            linha = leitura.readLine();
        }

        pacienteService.obterLista().forEach(System.out::println);

        leitura.close();
    }
}
