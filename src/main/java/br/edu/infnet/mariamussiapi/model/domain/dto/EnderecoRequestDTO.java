package br.edu.infnet.mariamussiapi.model.domain.dto;

import br.edu.infnet.mariamussiapi.model.domain.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class EnderecoRequestDTO {

    @NotBlank(message = "O CEP é obrigatório.")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP inválido. Use o formato XXXXX-XXX.")
    private String cep;

    public EnderecoRequestDTO(Endereco endereco) {
        this.cep = endereco.getCep();
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
