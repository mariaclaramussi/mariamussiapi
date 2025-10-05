package br.edu.infnet.agendamento.mappers;

import br.edu.infnet.agendamento.clients.EnderecoFeignClient;
import br.edu.infnet.agendamento.dto.EnderecoRequestDTO;
import br.edu.infnet.agendamento.dto.EnderecoResponseDTO;
import br.edu.infnet.agendamento.model.domain.Endereco;

public class EnderecoMapper {

    public static Endereco toEntity(EnderecoResponseDTO response) {
        if (response == null) return null;

        Endereco endereco = new Endereco();
        endereco.setCep(response.getCep());
        endereco.setBairro(response.getBairro());
        endereco.setCidade(response.getCidade());
        endereco.setComplemento(response.getComplemento());
        endereco.setUf(response.getUf());
        endereco.setLogradouro(response.getLogradouro());
        return endereco;
    }

    public static EnderecoResponseDTO toDTO(EnderecoFeignClient.EnderecoResponse response) {
        EnderecoResponseDTO dto = new EnderecoResponseDTO();
        dto.setCep(response.getCep());
        dto.setLogradouro(response.getLogradouro());
        dto.setBairro(response.getBairro());
        dto.setCidade(response.getCidade());
        dto.setUf(response.getUf());
        dto.setComplemento(response.getComplemento());
        return dto;
    }
}