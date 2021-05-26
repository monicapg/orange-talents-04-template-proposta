package br.com.zup.propostas.cartoes;

import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.List;

public class AssociacaoDeCartaoResponse {

    private String id;
    private String emitidoEm;
    private String titular;
    private List<?> bloqueios;
    private List<?> avisos;
    private List<?> carteiras;
    private List<?> parcelas;
    private BigDecimal limite;
    private boolean renegociacao;
    @Embedded
    private Vencimento vencimento;
    private Long idProposta;

//    @Enumerated(EnumType.STRING)
//    ResultadoAssociacao resultadoAssociacao;

    @Deprecated
    public AssociacaoDeCartaoResponse() {
    }

    public AssociacaoDeCartaoResponse(String id,
                                      String emitidoEm,
                                      String titular,
                                      List<?> bloqueios,
                                      List<?> avisos,
                                      List<?> carteiras,
                                      List<?> parcelas,
                                      BigDecimal limite,
                                      boolean renegociacao,
                                      Vencimento vencimento,
                                      Long idProposta) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.bloqueios = bloqueios;
        this.avisos = avisos;
        this.carteiras = carteiras;
        this.parcelas = parcelas;
        this.limite = limite;
        this.renegociacao = renegociacao;
        this.vencimento = vencimento;
        this.idProposta = idProposta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmitidoEm() {
        return emitidoEm;
    }

    public void setEmitidoEm(String emitidoEm) {
        this.emitidoEm = emitidoEm;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public List<?> getBloqueios() {
        return bloqueios;
    }

    public void setBloqueios(List<?> bloqueios) {
        this.bloqueios = bloqueios;
    }

    public List<?> getAvisos() {
        return avisos;
    }

    public void setAvisos(List<?> avisos) {
        this.avisos = avisos;
    }

    public List<?> getCarteiras() {
        return carteiras;
    }

    public void setCarteiras(List<?> carteiras) {
        this.carteiras = carteiras;
    }

    public List<?> getParcelas() {
        return parcelas;
    }

    public void setParcelas(List<?> parcelas) {
        this.parcelas = parcelas;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    public boolean isRenegociacao() {
        return renegociacao;
    }

    public void setRenegociacao(boolean renegociacao) {
        this.renegociacao = renegociacao;
    }

    public Vencimento getVencimento() {
        return vencimento;
    }

    public void setVencimento(Vencimento vencimento) {
        this.vencimento = vencimento;
    }

    public Long getIdProposta() {
        return idProposta;
    }

    public void setIdProposta(Long idProposta) {
        this.idProposta = idProposta;
    }

    public Cartao paraCartao() {

        return new Cartao(id,
                emitidoEm,
                titular,
//                bloqueios,
//                avisos,
//                carteiras,
//                parcelas,
                limite,
                renegociacao,
                vencimento,
                idProposta);
    }
}