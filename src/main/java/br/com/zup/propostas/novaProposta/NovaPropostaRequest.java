package br.com.zup.propostas.novaProposta;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class NovaPropostaRequest {

    @NotBlank(message = "obrigatório.")
    private String nome;

    @Email
    @NotBlank(message = "obrigatório.")
    private String email;

    @NotNull(message = "obrigatório.")
    @PositiveOrZero(message = "não pode ser valor negativo.")
    private BigDecimal salario;

    @NotBlank
    @Documento
    private String documento;

    @NotNull(message = "obrigatório.")
    @Valid
    @JsonProperty("endereco")
    private EnderecoRequest endereco;


    public NovaPropostaRequest(String nome,
                               String email,
                               BigDecimal salario,
                               String documento,
                               EnderecoRequest endereco) {

        this.nome = nome;
        this.email = email;
        this.salario = salario;
        this.documento = documento;
        this.endereco = endereco;

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
        return endereco;
    }

    public Proposta paraProposta() {
        Endereco novoEndereco = endereco.paraEndereco();

        return new Proposta(nome, email, salario, documento, novoEndereco);
    }
}
