package br.edu.infnet.agendamento.controllers;


import br.edu.infnet.agendamento.model.domain.Agendamento;
import br.edu.infnet.agendamento.model.domain.Medico;
import br.edu.infnet.agendamento.model.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public ResponseEntity<List<Medico>> obterMedicos() {
        List<Medico> lista = medicoService.obterLista();

        return ResponseEntity.ok(lista);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Medico> obterPorId(@PathVariable Integer id) {
        Medico medico = medicoService.obterPorId(id);

        return ResponseEntity.ok(medico);
    }

    @GetMapping(value="/{id}/agenda")
    public ResponseEntity<Optional<List<Agendamento>>> obterAgendamentos(@PathVariable Integer id) {
       Optional<List<Agendamento>> agendamentos = medicoService.verificarAgendamentos(id);

       if (agendamentos.isEmpty()) {
            return ResponseEntity.noContent().build();
       }

        return ResponseEntity.ok(agendamentos);
    }

    @PostMapping
    public ResponseEntity<Medico> criarMedico(@Valid @RequestBody Medico medico) {
        Medico novoMedico = medicoService.adicionar(medico);
        return  ResponseEntity.status(HttpStatus.CREATED).body(novoMedico);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Medico> editarMedico(@PathVariable("id") Integer id, @Valid @RequestBody Medico medico) {
        Medico medicoAlterado =  medicoService.editar(id, medico);
        return ResponseEntity.ok().body(medicoAlterado);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirMedico(@PathVariable("id") Integer id) {
        medicoService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
