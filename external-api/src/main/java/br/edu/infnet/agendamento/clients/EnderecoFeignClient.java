package br.edu.infnet.agendamento.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "consultaEndereco", url = "${clients.api.url}")
public interface EnderecoFeignClient {

    @GetMapping("/api/consulta-endereco/{cep}")
    EnderecoResponse obterEnderecoPorCep(@PathVariable("cep") String cep);

    class EnderecoResponse {
        private String cep;
        private String uf;
        private String logradouro;
        private String bairro;
        private String cidade;
        private String complemento;

        public String getCep() {
            return cep;
        }

        public void setCep(String cep) {
            this.cep = cep;
        }

        public String getUf() {
            return uf;
        }

        public void setUf(String uf) {
            this.uf = uf;
        }

        public String getLogradouro() {
            return logradouro;
        }

        public void setLogradouro(String logradouro) {
            this.logradouro = logradouro;
        }

        public String getBairro() {
            return bairro;
        }

        public void setBairro(String bairro) {
            this.bairro = bairro;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        public String getComplemento() {
            return complemento;
        }

        public void setComplemento(String complemento) {
            this.complemento = complemento;
        }
    }
}
