package br.com.zup.propostas.cartoes;

public class AssociacaoDeCartaoRequest {
    String documento;
    String nome;
    String idProposta;

    @Deprecated
    public AssociacaoDeCartaoRequest() {}

    public AssociacaoDeCartaoRequest(String documento, String nome, String idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.idProposta = idProposta;
    }
}
