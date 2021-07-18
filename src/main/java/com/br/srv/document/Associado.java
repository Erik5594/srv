package com.br.srv.document;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Transient;

/**
 * @author erik_
 * Data Criacao: 17/07/2021 - 23:18
 */
public class Associado {

    private String nome;
    private String cnpjCpf;
    @Transient
    private String status;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpjCpf() {
        if(StringUtils.isNotBlank(this.cnpjCpf)){
            setCnpjCpf(this.cnpjCpf.replaceAll("\\D", ""));
        }
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
