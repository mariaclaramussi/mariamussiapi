package br.edu.infnet.mariamussiapi.model.domain.dto;

import br.edu.infnet.mariamussiapi.model.domain.Endereco;

public class EnderecoResponseDTO {

    private String cep;
    private String uf;
    private String rua;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String complemento;

    public EnderecoResponseDTO(Endereco endereco) {
        this.cep = endereco.getCep();
        this.uf = endereco.getUf();
        this.rua = endereco.getRua();
        this.logradouro = endereco.getLogradouro();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.complemento = endereco.getComplemento();
    }

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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
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
