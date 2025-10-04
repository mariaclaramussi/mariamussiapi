package br.edu.infnet.agendamento.controllers;


import br.edu.infnet.agendamento.model.domain.Agendamento;
import br.edu.infnet.agendamento.model.service.AgendamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> obterTodosAgendamentos() {
        List<Agendamento> lista = agendamentoService.obterLista();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Agendamento> obterAgendamento(@PathVariable("id") Integer id) {
        Agendamento agendamento = agendamentoService.obterPorId(id);
        return ResponseEntity.ok(agendamento);
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
    public ResponseEntity<Agendamento> criarAgendamento(@Valid @RequestBody Agendamento agendamento) {
        Agendamento novoAgendamento = agendamentoService.adicionar(agendamento);

        return  ResponseEntity.status(HttpStatus.CREATED).body(novoAgendamento);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Agendamento> editarAgendamento(@PathVariable("id") Integer id, @RequestBody Agendamento agendamento) {
        Agendamento agendamentoAlterado =  agendamentoService.editar(id, agendamento);

        return ResponseEntity.ok().body(agendamentoAlterado);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirAgendamento(@PathVariable("id") Integer id) {
        agendamentoService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
