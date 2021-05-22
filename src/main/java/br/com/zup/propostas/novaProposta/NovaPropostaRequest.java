package br.com.zup.propostas.novaProposta;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class NovaPropostaRequest {

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    @NotNull
    @PositiveOrZero
    private BigDecimal salario;

    @NotBlank
    @Documento
    private String documento;

    @NotNull
    @JsonProperty("endereco")
    private EnderecoRequest enderecoRequest;

    @Deprecated
    NovaPropostaRequest() {
    }

    public NovaPropostaRequest(String nome,
                               String email,
                               BigDecimal salario,
                               String documento,
                               EnderecoRequest endereco) {

        this.nome = nome;
        this.email = email;
        this.salario = salario;
        this.documento = documento;
        this.enderecoRequest = endereco;

    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getDocumento() {
        return documento;
    }

    public EnderecoRequest getEndereco() {
        return enderecoRequest;
    }

    public Proposta paraProposta() {
        Endereco novoEndereco = enderecoRequest.paraEndereco();

        return new Proposta(nome, email, salario, documento, novoEndereco);
    }
}
