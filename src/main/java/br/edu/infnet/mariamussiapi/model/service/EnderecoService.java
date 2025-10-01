package br.edu.infnet.mariamussiapi.model.service;

import br.edu.infnet.mariamussiapi.model.clients.EnderecoFeignClient;
import br.edu.infnet.mariamussiapi.model.domain.Endereco;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private final EnderecoFeignClient enderecoFeignClient;

    public EnderecoService(EnderecoFeignClient enderecoFeignClient) {
        this.enderecoFeignClient = enderecoFeignClient;
    }

    public Endereco obterEndereco(String cep) {
        return enderecoFeignClient.obterEnderecoPorCep(cep);
    }

}
