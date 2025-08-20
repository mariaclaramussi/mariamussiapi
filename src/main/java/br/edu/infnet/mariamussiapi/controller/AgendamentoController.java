package br.edu.infnet.mariamussiapi.controller;

import br.edu.infnet.mariamussiapi.model.domain.Agendamento;
import br.edu.infnet.mariamussiapi.model.service.AgendamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @GetMapping
    public List<Agendamento> obterTodosAgendamentos() {
        return agendamentoService.obterLista();
    }

    @GetMapping(value = "/{id}")
    public Agendamento obterAgendamento(@PathVariable Integer id) {
        return agendamentoService.obterPorId(id);
    }

    @GetMapping(value = "/{id}/validar")
    public Boolean validarAgendamento(@PathVariable Integer id) {
        return agendamentoService.validarAgendamento(id);
    }

    @PostMapping
    public ResponseEntity<Agendamento> criaAgendamento(@RequestBody Agendamento agendamento) {
        Agendamento novoAgendamento = agendamentoService.adicionar(agendamento);

        return  ResponseEntity.status(HttpStatus.CREATED).body(novoAgendamento);
    }

    @PutMapping(value = "/{id}")
    public Agendamento editarAgendamento(@PathVariable Integer id, @RequestBody Agendamento agendamento) {
        return agendamentoService.editar(id, agendamento);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirAgendamento(@PathVariable Integer id) {
        agendamentoService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
