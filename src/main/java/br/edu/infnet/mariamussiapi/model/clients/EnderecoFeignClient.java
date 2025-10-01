package br.edu.infnet.mariamussiapi.model.clients;

import br.edu.infnet.mariamussiapi.model.domain.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "consultaEndereco", url = "${endereco.api.url}")
public interface EnderecoFeignClient {

    @GetMapping("/api/consulta-endereco/{cep}")
    Endereco obterEnderecoPorCep(@PathVariable String cep);
}
