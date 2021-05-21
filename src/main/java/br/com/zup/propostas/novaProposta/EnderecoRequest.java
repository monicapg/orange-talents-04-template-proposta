package br.com.zup.propostas.novaProposta;

import javax.validation.constraints.NotBlank;

public class EnderecoRequest {

    @NotBlank
    String cep;
    @NotBlank
    String rua;
    @NotBlank
    String numero;
    @NotBlank
    String complemento;
    @NotBlank
    String bairro;
    @NotBlank
    String cidade;
    @NotBlank
    String estado;

    @Deprecated
    EnderecoRequest(){}

    public EnderecoRequest(String cep, String rua, String numero, String complemento, String bairro, String cidade, String estado) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "EnderecoRequest{" +
                "cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }


    public Endereco paraEndereco() {
        return new Endereco(cep, rua, numero, complemento, bairro, cidade, estado);
    }
}
