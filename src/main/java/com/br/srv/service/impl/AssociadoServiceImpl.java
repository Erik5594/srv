package com.br.srv.service.impl;

import com.br.srv.document.Associado;
import com.br.srv.service.AssociadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author erik_
 * Data Criacao: 18/07/2021 - 12:43
 */
@Service
public class AssociadoServiceImpl implements AssociadoService {

    @Override
    public String consultarCpf(String cpf) {
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Void> request = RequestEntity.get(URI.create("https://user-info.herokuapp.com//users/"+cpf)).build();
        try {
            ResponseEntity<Associado> response = restTemplate.exchange(request, Associado.class);
            if (HttpStatus.OK.equals(response.getStatusCode())) {
                Associado associado = response.getBody();
                if (associado != null) {
                    return associado.getStatus();
                }
            }
        }catch (HttpClientErrorException e) {
            if(!HttpStatus.NOT_FOUND.equals(e.getStatusCode())){
                throw e;
            }
        }
        return null;
    }
}
