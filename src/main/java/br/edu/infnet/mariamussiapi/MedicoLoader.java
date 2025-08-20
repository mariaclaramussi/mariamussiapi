package br.edu.infnet.mariamussiapi;

import br.edu.infnet.mariamussiapi.model.domain.Medico;
import br.edu.infnet.mariamussiapi.model.service.MedicoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class MedicoLoader implements ApplicationRunner {
    private final MedicoService medicoService;

    public MedicoLoader(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader arquivo = new FileReader("medicos.txt");
        BufferedReader leitura = new BufferedReader(arquivo);

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null) {
            campos = linha.split(";");

            Medico medico = new Medico();
            medico.setNome(campos[0]);
            medico.setCRM(campos[1]);
            medico.setEspecialidade(campos[2]);
            medico.setCpf(campos[3]);

            medicoService.adicionar(medico);
            System.out.println(medico);

            linha = leitura.readLine();
        }

        System.out.println("- " + medicoService.obterLista().size());

        leitura.close();
    }
}
