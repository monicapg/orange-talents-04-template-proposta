package br.com.zup.propostas.biometria;

import br.com.zup.propostas.cartoes.Cartao;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Biometria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idBiometria;
    @Column(columnDefinition = "TEXT")
    String biometria;
    @ManyToOne @JoinColumn(name = "id_cartao")
    Cartao cartao;
    @NotNull
    LocalDate dataDeCadastro;

    @Deprecated
    public Biometria(){}

    public Biometria(String biometria, Cartao cartao) {
        this.biometria = biometria;
        this.cartao = cartao;
        this.dataDeCadastro = LocalDate.now();
    }

    public LocalDate getDataDeCadastro() {
        return dataDeCadastro;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public Long getId() {
        return idBiometria;
    }
}
