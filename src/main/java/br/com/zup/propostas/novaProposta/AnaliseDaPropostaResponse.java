package br.com.zup.propostas.novaProposta;

public class AnaliseDaPropostaResponse {

    private String documento;
    private String nome;
    Long idProposta;
    private ResultadoSolicitacao resultadoSolicitacao;

    //GETTERS
     public String getDocumento() {
        return documento;
    }
    public String getNome() {
        return nome;
    }

    public Long getIdProposta() {
        return idProposta;
    }

    public ResultadoSolicitacao getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

    public Status status() {
         return resultadoSolicitacao.getStatus();
    }
}

