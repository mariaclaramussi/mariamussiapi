package br.edu.infnet.mariamussiapi.model.service;

import br.edu.infnet.mariamussiapi.model.clients.EnderecoFeignClient;
import br.edu.infnet.mariamussiapi.model.domain.Endereco;
import br.edu.infnet.mariamussiapi.model.domain.dto.EnderecoRequestDTO;
import br.edu.infnet.mariamussiapi.model.domain.dto.EnderecoResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private final EnderecoFeignClient enderecoFeignClient;

    public EnderecoService(EnderecoFeignClient enderecoFeignClient) {
        this.enderecoFeignClient = enderecoFeignClient;
    }

    public EnderecoResponseDTO obterEndereco(EnderecoRequestDTO endereco) {
        Endereco enderecoEncontrado = enderecoFeignClient.obterEnderecoPorCep(endereco.getCep());

        return new EnderecoResponseDTO(enderecoEncontrado);
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
