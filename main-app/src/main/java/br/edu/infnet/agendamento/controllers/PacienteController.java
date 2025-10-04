package br.edu.infnet.agendamento.controllers;


import br.edu.infnet.agendamento.model.domain.Agendamento;
import br.edu.infnet.agendamento.model.domain.Paciente;
import br.edu.infnet.agendamento.model.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping public ResponseEntity<List<Paciente>> obterPacientes() {
        List<Paciente> lista = pacienteService.obterLista();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Paciente> obterPorId(@PathVariable Integer id) {
        Paciente paciente =  pacienteService.obterPorId(id);

        return ResponseEntity.ok(paciente);
    }

    @GetMapping(value="/{id}/consultas")
    public ResponseEntity<Optional<List<Agendamento>>> exibirConsultas(@PathVariable Integer id) {
        Optional<List<Agendamento>> agendamentos = pacienteService.verificarConsultas(id);

        if (agendamentos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        System.out.println(agendamentos);
        return ResponseEntity.status(HttpStatus.FOUND).body(agendamentos);
    }

    @PostMapping
    public ResponseEntity<Paciente> criarPaciente(@Valid @RequestBody Paciente paciente) {
        Paciente novoPaciente = pacienteService.adicionar(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPaciente);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Paciente> editarPaciente(@PathVariable Integer id, @RequestBody Paciente paciente) {
        Paciente pacienteAlterado =  pacienteService.editar(id, paciente);
        return ResponseEntity.ok().body(paciente);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirPaciente(@PathVariable Integer id) {
        pacienteService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
