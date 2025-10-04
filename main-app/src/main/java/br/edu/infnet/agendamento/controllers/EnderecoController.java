package br.edu.infnet.agendamento.controllers;


import br.edu.infnet.agendamento.dto.EnderecoRequestDTO;
import br.edu.infnet.agendamento.dto.EnderecoResponseDTO;
import br.edu.infnet.agendamento.model.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<EnderecoResponseDTO> obterEnderecoPorCep (@PathVariable("cep") String cep) {
        EnderecoRequestDTO requestBody = new EnderecoRequestDTO();
        requestBody.setCep(cep);

        EnderecoResponseDTO resultadoEndereco = enderecoService.obterEndereco(requestBody);

        return ResponseEntity.ok(resultadoEndereco);
    }
}
