package br.edu.infnet.mariamussiapi.model.domain;

public class Endereco {

    private String cep;
    private String UF;
    private String rua;
    private String pais;
    private String complemento;

    @Override
    public String toString() {
        return "Endereco {" +
                "cep='" + cep + '\'' +
                ", UF='" + UF + '\'' +
                ", rua='" + rua + '\'' +
                ", pais='" + pais + '\'' +
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
