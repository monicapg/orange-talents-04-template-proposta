package br.com.zup.propostas.novaProposta;

import br.com.zup.propostas.cartoes.CartaoResponse;

import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class NovaPropostaResponse {
    Long id;
    private String nome;
    private String email;
    private BigDecimal salario;
    private String documento;
    private Endereco endereco;
    @Enumerated(EnumType.STRING)
    private Status status;
    CartaoResponse cartao;
    Proposta proposta;

    public NovaPropostaResponse(Proposta proposta) {
        this.id = proposta.getId();
        this.nome = proposta.getNome();
        this.email = proposta.getEmail();
        this.salario = proposta.getSalario();
        this.documento = proposta.getDocumento();
        this.endereco = proposta.getEndereco();
        this.status = proposta.getStatus();
        if(proposta.possuiCartaoAssociado()) {
            this.cartao = new CartaoResponse(proposta.getCartao());
        }
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
