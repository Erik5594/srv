package com.br.srv.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author erik_
 * Data Criacao: 16/07/2021 - 08:17
 */

@Document
public class Pauta {

    public Pauta(String id, String assunto) {
        this.id = id;
        this.assunto = assunto;
    }

    @Id
    private String id;
    private String assunto;

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
}
