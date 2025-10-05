package br.edu.infnet.agendamento.model.service;

import br.edu.infnet.agendamento.clients.EnderecoFeignClient;
import br.edu.infnet.agendamento.dto.EnderecoResponseDTO;
import br.edu.infnet.agendamento.mappers.EnderecoMapper;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private final EnderecoFeignClient enderecoFeignClient;

    public EnderecoService(EnderecoFeignClient enderecoFeignClient) {
        this.enderecoFeignClient = enderecoFeignClient;
    }

    private void validarCep(String cep) {
        if (cep == null || !cep.matches("\\d{8}")) {
            throw new IllegalArgumentException("CEP inválido. Deve conter exatamente 8 dígitos numéricos.");
        }
    }

    public EnderecoResponseDTO obterEndereco(String cep) {
        String cepSanitizado = cep.replaceAll("[^0-9]", "");

        validarCep(cepSanitizado);

        EnderecoFeignClient.EnderecoResponse enderecoResponse = enderecoFeignClient.obterEnderecoPorCep(cepSanitizado);
        if (enderecoResponse == null) {
            throw new IllegalArgumentException("Endereço não encontrado para o CEP: " + cep);
        }
        return EnderecoMapper.toDTO(enderecoResponse);
    }
}
