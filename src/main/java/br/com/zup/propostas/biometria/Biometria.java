package br.com.zup.propostas.biometria;

import br.com.zup.propostas.cartoes.Cartao;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
public class Biometria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idBiometria;
    @Column(columnDefinition = "TEXT", length = 1000)
    String biometria;
    @ManyToOne @JoinColumn(name = "id_cartao")
    Cartao cartao;

    @Deprecated
    public Biometria(){}

    public Biometria(String biometria, Cartao cartao) {
        this.biometria = biometria;
        this.cartao = cartao;
    }

    public Long getId() {
        return idBiometria;
    }
}
