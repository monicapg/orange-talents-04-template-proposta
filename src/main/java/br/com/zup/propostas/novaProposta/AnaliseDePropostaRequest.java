package br.com.zup.propostas.novaProposta;


public class AnaliseDePropostaRequest {
    private String documento, nome;
    Long idProposta;

    public AnaliseDePropostaRequest(String documento, String nome, Long idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.idProposta = idProposta;

    }
    @Deprecated //c. vazio para o Spring
    public AnaliseDePropostaRequest() { }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdProposta() {
        return idProposta;
    }
}
