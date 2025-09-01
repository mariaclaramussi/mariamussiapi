package br.edu.infnet.mariamussiapi.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O CEP é obrigatório.")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP inválido. Use o formato XXXXX-XXX.")
    private String cep;

    @NotBlank
    @Size(min = 2, max = 2, message = "O UF deve ter 2 caracteres.")
    private String UF;

    @NotBlank(message = "O campo de rua é obrigatório.")
    @Size(min = 10, message = "O campo de rua deve ter no minimo 10 caracteres.")
    private String rua;

    @NotBlank(message = "O bairro é obrigatório.")
    @Size(min = 3, message = "bairro deve ter no minimo 3 caracteres.")
    private String bairro;

    private String complemento;

    @Override
    public String toString() {
        return "Endereco {" +
                "cep='" + cep + '\'' +
                ", UF='" + UF + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", complemento='" + complemento + '\'' +
                '}';
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String pais) {
        this.bairro = pais;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
