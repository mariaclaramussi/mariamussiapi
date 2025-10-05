package br.edu.infnet.agendamento.controllers;

import br.edu.infnet.agendamento.dto.EnderecoResponseDTO;
import br.edu.infnet.agendamento.dto.PacienteRequestDTO;
import br.edu.infnet.agendamento.dto.PacienteResponseDTO;
import br.edu.infnet.agendamento.mappers.EnderecoMapper;
import br.edu.infnet.agendamento.mappers.PacienteMapper;
import br.edu.infnet.agendamento.model.domain.Agendamento;
import br.edu.infnet.agendamento.model.domain.Paciente;
import br.edu.infnet.agendamento.model.service.EnderecoService;
import br.edu.infnet.agendamento.model.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;
    private final EnderecoService enderecoService;

    public PacienteController(PacienteService pacienteService, EnderecoService enderecoService) {
        this.pacienteService = pacienteService;
        this.enderecoService = enderecoService;
    }

    @GetMapping public ResponseEntity<List<PacienteResponseDTO>> obterPacientes() {
        List<PacienteResponseDTO> lista = pacienteService.obterLista().stream().map(PacienteResponseDTO::new).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<PacienteResponseDTO> obterPorId(@PathVariable("id") Integer id) {
        Paciente paciente =  pacienteService.obterPorId(id);

        return ResponseEntity.ok(PacienteMapper.toDTO(paciente));
    }

    @GetMapping(value="/{id}/consultas")
    public ResponseEntity<Optional<List<Agendamento>>> exibirConsultas(@PathVariable("id") Integer id) {
        Optional<List<Agendamento>> agendamentos = pacienteService.verificarConsultas(id);

        if (agendamentos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        System.out.println(agendamentos);
        return ResponseEntity.status(HttpStatus.FOUND).body(agendamentos);
    }

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> criarPaciente(@Valid @RequestBody PacienteRequestDTO requestDTO) {
        EnderecoResponseDTO endereco = enderecoService.obterEndereco(requestDTO.getCep());

        Paciente paciente = PacienteMapper.toEntity(requestDTO, EnderecoMapper.toEntity(endereco));
        Paciente novoPaciente = pacienteService.adicionar(paciente);

        return ResponseEntity.status(HttpStatus.CREATED).body(PacienteMapper.toDTO(novoPaciente));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PacienteResponseDTO> editarPaciente(@PathVariable("id") Integer id, @Valid @RequestBody PacienteRequestDTO requestDTO) {
        EnderecoResponseDTO endereco = enderecoService.obterEndereco(requestDTO.getCep());

        Paciente paciente = PacienteMapper.toEntity(requestDTO, EnderecoMapper.toEntity(endereco));
        Paciente pacienteAlterado =  pacienteService.editar(id, paciente);

        return ResponseEntity.ok().body(PacienteMapper.toDTO(pacienteAlterado));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirPaciente(@PathVariable("id") Integer id) {
        pacienteService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
