package br.edu.infnet.agendamento.controllers;

import br.edu.infnet.agendamento.dto.AgendamentoRequestDTO;
import br.edu.infnet.agendamento.dto.AgendamentoResponseDTO;
import br.edu.infnet.agendamento.mappers.AgendamentoMapper;
import br.edu.infnet.agendamento.model.domain.Agendamento;
import br.edu.infnet.agendamento.model.domain.Medico;
import br.edu.infnet.agendamento.model.domain.Paciente;
import br.edu.infnet.agendamento.model.service.AgendamentoService;
import br.edu.infnet.agendamento.model.service.MedicoService;
import br.edu.infnet.agendamento.model.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;
    private final PacienteService pacienteService;
    private final MedicoService medicoService;


    public AgendamentoController(AgendamentoService agendamentoService, PacienteService pacienteService, MedicoService medicoService) {
        this.agendamentoService = agendamentoService;
        this.pacienteService = pacienteService;
        this.medicoService = medicoService;
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoResponseDTO>> obterTodosAgendamentos() {
        List<AgendamentoResponseDTO> lista = agendamentoService.obterLista().stream().map(AgendamentoResponseDTO::new).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AgendamentoResponseDTO> obterAgendamento(@PathVariable("id") Integer id) {
        Agendamento agendamento = agendamentoService.obterPorId(id);

        return ResponseEntity.ok(AgendamentoMapper.toDTO(agendamento));
    }

    @GetMapping(value = "/verificarAgendamento")
    public ResponseEntity<Boolean> verificarAgendamento(@Valid @RequestBody String data) {
        Boolean exists = agendamentoService.verificarAgendamento(data);

        if(exists) {
            return new ResponseEntity<>(exists, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(exists, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<AgendamentoResponseDTO> criarAgendamento(@Valid @RequestBody AgendamentoRequestDTO request) {
        Paciente paciente = pacienteService.obterPorId(request.getPacienteId());
        Medico medico = medicoService.obterPorId(request.getMedicoId());

        Agendamento agendamento = AgendamentoMapper.toEntity(request, paciente, medico);
        Agendamento novoAgendamento = agendamentoService.adicionar(agendamento);

        return  ResponseEntity.status(HttpStatus.CREATED).body(AgendamentoMapper.toDTO(novoAgendamento));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AgendamentoResponseDTO> editarAgendamento(@PathVariable("id") Integer id, @Valid @RequestBody AgendamentoRequestDTO request) {
        Paciente paciente = pacienteService.obterPorId(request.getPacienteId());
        Medico medico = medicoService.obterPorId(request.getMedicoId());

        Agendamento agendamento = AgendamentoMapper.toEntity(request, paciente, medico);
        Agendamento agendamentoAlterado =  agendamentoService.editar(id, agendamento);

        return ResponseEntity.ok().body(AgendamentoMapper.toDTO(agendamentoAlterado));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirAgendamento(@PathVariable("id") Integer id) {
        agendamentoService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
