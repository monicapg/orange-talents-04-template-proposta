package br.com.zup.propostas.cartoes;

import br.com.zup.propostas.novaProposta.Proposta;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cartao")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCartao;
    private String numeroDoCartao;
    private String emitidoEm;
    private String titular;
//    private List<?> bloqueios;
//    private List<?> avisos;
//    private List<?> carteiras;
//    private List<?> parcelas;
    private BigDecimal limite;
    private boolean renegociacao;
    @Embedded
    private Vencimento vencimento;
    private Long idProposta;

//    @OneToOne @JoinColumn(name = "proposta")
//    Proposta proposta;

    @Deprecated
    public Cartao(){}

    public Cartao(String numeroDoCartao,
                  String emitidoEm,
                  String titular,
                  //List<?> bloqueios,
                  //List<?> avisos,
                  //List<?> carteiras,
                  //List<?> parcelas,
                  BigDecimal limite,
                  boolean renegociacao,
                  Vencimento vencimento,
                  Long idProposta) {
        this.numeroDoCartao = numeroDoCartao;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
//        this.bloqueios = bloqueios;
//        this.avisos = avisos;
//        this.carteiras = carteiras;
//        this.parcelas = parcelas;
        this.limite = limite;
        this.renegociacao = renegociacao;
        this.vencimento = vencimento;
        this.idProposta = idProposta;

    }

}