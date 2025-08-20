package br.edu.infnet.mariamussiapi.controller;

import br.edu.infnet.mariamussiapi.model.domain.Agendamento;
import br.edu.infnet.mariamussiapi.model.domain.Medico;
import br.edu.infnet.mariamussiapi.model.service.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public List<Medico> obterMedicos() {
        return medicoService.obterLista();
    }

    @GetMapping(value="/{id}")
    public Medico obterPorId(@PathVariable Integer id) {
        return medicoService.obterPorId(id);
    }

    @GetMapping(value="/{id}/agenda")
    public List<Agendamento> obterAgendamentos(@PathVariable Integer id) {
        return medicoService.verificarAgendamentos(id);
    }

    @PostMapping
    public ResponseEntity<Medico> criarMedico(@RequestBody Medico medico) {
        Medico novoMedico = medicoService.adicionar(medico);
        return  ResponseEntity.status(HttpStatus.CREATED).body(novoMedico);
    }

    @PutMapping(value = "/{id}")
    public Medico editarMedico(@PathVariable Integer id, @RequestBody Medico medico) {
        return medicoService.editar(id, medico);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirMedico(@PathVariable Integer id) {
        medicoService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
