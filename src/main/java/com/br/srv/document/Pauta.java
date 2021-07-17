package com.br.srv.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author erik_
 * Data Criacao: 16/07/2021 - 08:17
 */

@Document
public class Pauta {

    @Id
    private String id;
    private String assunto;
    private Date dataCadastro;
    private boolean votacaoAtiva;

    public Pauta() {
        this.dataCadastro = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public boolean isVotacaoAtiva() {
        return votacaoAtiva;
    }

    public void setVotacaoAtiva(boolean votacaoAtiva) {
        this.votacaoAtiva = votacaoAtiva;
    }
}
