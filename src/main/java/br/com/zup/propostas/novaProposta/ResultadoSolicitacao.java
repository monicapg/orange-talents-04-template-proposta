package br.com.zup.propostas.novaProposta;

public enum ResultadoSolicitacao {

    COM_RESTRICAO(Status.NAO_ELEGIVEL),
    SEM_RESTRICAO(Status.ELEGIVEL);

    private Status status;

    ResultadoSolicitacao(Status status) {
        this.status = status;
    }

    @Deprecated
    ResultadoSolicitacao() {

    }

    public Status getStatus() {
        return status;
    }
}
