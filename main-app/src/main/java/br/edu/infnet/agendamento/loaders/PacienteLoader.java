package br.edu.infnet.agendamento.loaders;

import br.edu.infnet.agendamento.dto.EnderecoResponseDTO;
import br.edu.infnet.agendamento.mappers.EnderecoMapper;
import br.edu.infnet.agendamento.model.domain.Paciente;
import br.edu.infnet.agendamento.model.service.EnderecoService;
import br.edu.infnet.agendamento.model.service.PacienteService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Order(1)
@Component
public class PacienteLoader implements ApplicationRunner {
    private final PacienteService pacienteService;
    private final EnderecoService enderecoService;

    public PacienteLoader(PacienteService pacienteService, EnderecoService enderecoService) {
        this.pacienteService = pacienteService;
        this.enderecoService = enderecoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ClassPathResource resource = new ClassPathResource("pacientes.txt");
        BufferedReader leitura = new BufferedReader(new InputStreamReader(resource.getInputStream()));

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null) {
            campos = linha.split(";");

            Paciente paciente = new Paciente();
            paciente.setNome(campos[0]);
            paciente.setCpf(campos[1]);
            paciente.setNomeMae(campos[2]);
            paciente.setNascimento(campos[3]);
            paciente.setSexo(campos[4]);

            EnderecoResponseDTO enderecoResponse = enderecoService.obterEndereco(campos[5]);
            paciente.setEndereco(EnderecoMapper.toEntity(enderecoResponse));

            pacienteService.adicionar(paciente);

            linha = leitura.readLine();
        }

        System.out.println("----PACIENTES-----");
        pacienteService.obterLista().forEach(System.out::println);
        System.out.println("-----------------------------");

        leitura.close();
    }
}
