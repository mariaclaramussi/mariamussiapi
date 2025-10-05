package br.edu.infnet.agendamento.controllers;

import br.edu.infnet.agendamento.clients.BrasilApiFeignClients;
import br.edu.infnet.agendamento.model.service.FeriadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/feriados")
public class FeriadosController {
    private final FeriadoService feriadoService;

    public FeriadosController(FeriadoService feriadoService) {
        this.feriadoService = feriadoService;
    }

    @GetMapping("/{ano}")
    public ResponseEntity<List<BrasilApiFeignClients.Feriado>> obterPorAno(@PathVariable("ano") String ano) {
        System.out.println(ano);
        List<BrasilApiFeignClients.Feriado> feriados = feriadoService.obterFeriados(ano);

        return ResponseEntity.ok(feriados);
    }
}
