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
    public ResponseEntity<List<Agendamento>> obterTodosAgendamentos() {
        List<Agendamento> lista = agendamentoService.obterLista();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Agendamento> obterAgendamento(@PathVariable Integer id) {
        Agendamento agendamento = agendamentoService.obterPorId(id);
        return ResponseEntity.ok(agendamento);
    }

    @GetMapping(value = "/{id}/validar")
    public Boolean verificarAgendamento(@PathVariable Integer id) {
        return agendamentoService.verificarAgendamento(id);
    }

    @PostMapping
    public ResponseEntity<Agendamento> criarAgendamento(@RequestBody Agendamento agendamento) {
        Agendamento novoAgendamento = agendamentoService.adicionar(agendamento);

        return  ResponseEntity.status(HttpStatus.CREATED).body(novoAgendamento);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Agendamento> editarAgendamento(@PathVariable Integer id, @RequestBody Agendamento agendamento) {
        Agendamento agendamentoAlterado =  agendamentoService.editar(id, agendamento);

        return ResponseEntity.ok().body(agendamentoAlterado);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirAgendamento(@PathVariable Integer id) {
        agendamentoService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
