package br.com.zup.propostas.cartoes;

import javax.persistence.Embedded;
import java.math.BigDecimal;

public class CartaoResponse {

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

    public CartaoResponse(Cartao cartao) {}

    public CartaoResponse(Long idCartao,
                          String numeroDoCartao,
                          String emitidoEm,
                          String titular,
                          BigDecimal limite,
                          boolean renegociacao,
                          Vencimento vencimento,
                          Long idProposta) {
        this.idCartao = idCartao;
        this.numeroDoCartao = numeroDoCartao;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.limite = limite;
        this.renegociacao = renegociacao;
        this.vencimento = vencimento;
        this.idProposta = idProposta;
    }

}
