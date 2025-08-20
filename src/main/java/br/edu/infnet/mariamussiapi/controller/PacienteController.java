package br.edu.infnet.mariamussiapi.controller;

import br.edu.infnet.mariamussiapi.model.domain.Agendamento;
import br.edu.infnet.mariamussiapi.model.domain.Paciente;
import br.edu.infnet.mariamussiapi.model.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    @GetMapping
    public List<Paciente> obterPacientes() {
        return pacienteService.obterLista();
    }

    @GetMapping(value="/{id}")
    public Paciente obterPorId(@PathVariable Integer id) {
        return pacienteService.obterPorId(id);
    }

    @GetMapping(value="/{id}/consultas")
    public List<Agendamento> exibirConsultas(@PathVariable Integer id) {
        return pacienteService.verificarConsultas(id);
    }

    @PostMapping
    public ResponseEntity<Paciente> criarPaciente(@RequestBody Paciente paciente) {
        Paciente novoPaciente = pacienteService.adicionar(paciente);
        return  ResponseEntity.status(HttpStatus.CREATED).body(novoPaciente);
    }

    @PutMapping(value = "/{id}")
    public Paciente editarPaciente(@PathVariable Integer id, @RequestBody Paciente paciente) {
        return pacienteService.editar(id, paciente);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirPaciente(@PathVariable Integer id) {
        pacienteService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
