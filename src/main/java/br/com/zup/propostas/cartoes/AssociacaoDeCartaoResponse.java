package br.com.zup.propostas.cartoes;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class AssociacaoDeCartaoResponse {
    String documento, nome;
    String idProposta;

    @Enumerated(EnumType.STRING)
    ResultadoAssociacao resultadoAssociacao;

    @Deprecated
    public AssociacaoDeCartaoResponse(){}

    public AssociacaoDeCartaoResponse(String documento, String nome, String idProposta, ResultadoAssociacao resultadoAssociacao) {
        this.documento = documento;
        this.nome = nome;
        this.idProposta = idProposta;
        this.resultadoAssociacao = resultadoAssociacao;
    }

    public String getDocumento() {
        return documento;
    }


    public String getNome() {
        return nome;
    }


    public String getIdProposta() {
        return idProposta;
    }


    public ResultadoAssociacao getResultadoAssociacao() {
        return resultadoAssociacao;
    }

}
