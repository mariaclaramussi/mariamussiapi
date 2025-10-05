package br.edu.infnet.agendamento.controllers;


import br.edu.infnet.agendamento.dto.AgendamentoResponseDTO;
import br.edu.infnet.agendamento.dto.EnderecoResponseDTO;
import br.edu.infnet.agendamento.dto.MedicoRequestDTO;
import br.edu.infnet.agendamento.dto.MedicoResponseDTO;
import br.edu.infnet.agendamento.mappers.EnderecoMapper;
import br.edu.infnet.agendamento.mappers.MedicoMapper;
import br.edu.infnet.agendamento.model.domain.Agendamento;
import br.edu.infnet.agendamento.model.domain.Endereco;
import br.edu.infnet.agendamento.model.domain.Medico;
import br.edu.infnet.agendamento.model.service.EnderecoService;
import br.edu.infnet.agendamento.model.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/medicos")
public class MedicoController {

    private final MedicoService medicoService;
    private final EnderecoService enderecoService;

    public MedicoController(MedicoService medicoService, EnderecoService enderecoService) {
        this.medicoService = medicoService;
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<List<MedicoResponseDTO>> obterMedicos() {
        List<MedicoResponseDTO> lista = medicoService.obterLista().stream().map(MedicoResponseDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<MedicoResponseDTO> obterPorId(@PathVariable("id") Integer id) {
        Medico medico = medicoService.obterPorId(id);

        return ResponseEntity.ok(MedicoMapper.toDTO(medico));
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
    public ResponseEntity<MedicoResponseDTO> criarMedico(@Valid @RequestBody MedicoRequestDTO medicoRequest) {
        EnderecoResponseDTO endereco = enderecoService.obterEndereco(medicoRequest.getCep());

        Medico medico = MedicoMapper.toEntity(medicoRequest, EnderecoMapper.toEntity(endereco));
        Medico novoMedico = medicoService.adicionar(medico);

        return  ResponseEntity.status(HttpStatus.CREATED).body(MedicoMapper.toDTO(novoMedico));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MedicoResponseDTO> editarMedico(@PathVariable("id") Integer id, @Valid @RequestBody  MedicoRequestDTO medicoRequest) {
        EnderecoResponseDTO endereco = enderecoService.obterEndereco(medicoRequest.getCep());

        Medico medico = MedicoMapper.toEntity(medicoRequest, EnderecoMapper.toEntity(endereco));
        Medico medicoAlterado =  medicoService.editar(id, medico);

        return ResponseEntity.ok().body(MedicoMapper.toDTO(medicoAlterado));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirMedico(@PathVariable("id") Integer id) {
        medicoService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
