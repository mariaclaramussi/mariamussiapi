package br.edu.infnet.agendamento.model.service;


import br.edu.infnet.agendamento.clients.EnderecoFeignClient;
import br.edu.infnet.agendamento.dto.EnderecoRequestDTO;
import br.edu.infnet.agendamento.dto.EnderecoResponseDTO;
import br.edu.infnet.agendamento.model.domain.Endereco;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private final EnderecoFeignClient enderecoFeignClient;

    public EnderecoService(EnderecoFeignClient enderecoFeignClient) {
        this.enderecoFeignClient = enderecoFeignClient;
    }

    private Endereco copyFromViaCepResponse(EnderecoFeignClient.EnderecoResponse response) {
        Endereco endereco = new Endereco();
        endereco.setCep(response.getCep());
        endereco.setLogradouro(response.getLogradouro());
        endereco.setCidade(response.getCidade());
        endereco.setUf(response.getUf());
        endereco.setBairro(response.getBairro());
        endereco.setComplemento(response.getComplemento());

        return endereco;
    }

    public EnderecoResponseDTO obterEndereco(EnderecoRequestDTO endereco) {
        EnderecoFeignClient.EnderecoResponse enderecoEncontrado = enderecoFeignClient.obterEnderecoPorCep(endereco.getCep());
        Endereco enderecoFormatado = copyFromViaCepResponse(enderecoEncontrado);

        return new EnderecoResponseDTO(enderecoFormatado);
    }

    public Endereco mapEnderecoToEntity(EnderecoResponseDTO responseBody) {
        Endereco endereco = new Endereco();
        endereco.setCep(responseBody.getCep());
        endereco.setLogradouro(responseBody.getLogradouro());
        endereco.setCidade(responseBody.getCidade());
        endereco.setUf(responseBody.getUf());
        endereco.setBairro(responseBody.getBairro());
        endereco.setComplemento(responseBody.getComplemento());

        return endereco;
    }
}
