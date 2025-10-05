package br.edu.infnet.agendamento.loaders;

import br.edu.infnet.agendamento.dto.EnderecoResponseDTO;
import br.edu.infnet.agendamento.mappers.EnderecoMapper;
import br.edu.infnet.agendamento.model.domain.Medico;
import br.edu.infnet.agendamento.model.service.EnderecoService;
import br.edu.infnet.agendamento.model.service.MedicoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Order(2)
@Component
public class MedicoLoader implements ApplicationRunner {
    private final MedicoService medicoService;
    private final EnderecoService enderecoService;

    public MedicoLoader(MedicoService medicoService, EnderecoService enderecoService) {
        this.medicoService = medicoService;
        this.enderecoService = enderecoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ClassPathResource resource = new ClassPathResource("medicos.txt");
        BufferedReader leitura = new BufferedReader(new InputStreamReader(resource.getInputStream()));

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null) {
            campos = linha.split(";");

            Medico medico = new Medico();
            medico.setNome(campos[0]);
            medico.setCpf(campos[1]);
            medico.setNascimento(campos[2]);
            medico.setSexo(campos[3]);
            medico.setCRM(campos[4]);
            medico.setEspecialidade(campos[5]);

            EnderecoResponseDTO enderecoResponse = enderecoService.obterEndereco(campos[6]);
            medico.setEndereco(EnderecoMapper.toEntity(enderecoResponse));

            medicoService.adicionar(medico);

            linha = leitura.readLine();
        }

        System.out.println("----MÉDICOS-----");
        medicoService.obterLista().forEach(System.out::println);
        System.out.println("-----------------------------");

        leitura.close();
    }
}
