package com.br.srv.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author erik_
 * Data Criacao: 17/07/2021 - 21:23
 */
@Document
public class Votacao {
    @Id
    private String id;
    private String idPauta;
    private String voto;
    private String dataHora;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(String idPauta) {
        this.idPauta = idPauta;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
}
