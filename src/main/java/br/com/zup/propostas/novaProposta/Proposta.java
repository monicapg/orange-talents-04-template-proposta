package br.com.zup.propostas.novaProposta;

import br.com.zup.propostas.cartoes.Cartao;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Entity
@Table(name = "proposta")
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

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

    //@Valid precisa validar endereco
    @NotNull
    @Embedded
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(cascade = CascadeType.MERGE) @JoinColumn(name = "idCartao")
    Cartao cartao;

    public Proposta(@NotBlank String nome, @Email @NotBlank String email,
                    @NotNull @PositiveOrZero BigDecimal salario,
                    String documento, @NotNull Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.salario = salario;
        this.documento = documento;
        this.endereco = endereco;
    }

    @Deprecated
    Proposta() { }

    public Long getId() {
        return id;
    }

    public String getNome() {return nome; }

    public String getDocumento() { return documento;  }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}
