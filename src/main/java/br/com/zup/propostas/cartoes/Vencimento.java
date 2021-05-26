package br.com.zup.propostas.cartoes;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class Vencimento {

    private String id;
    private int dia;
    private Date dataDeCriacao;

    @Deprecated
    public Vencimento(){}

    public Vencimento(String id, int dia, Date dataDeCriacao) {
        this.id = id;
        this.dia = dia;
        this.dataDeCriacao = dataDeCriacao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public Date getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(Date dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }
}
