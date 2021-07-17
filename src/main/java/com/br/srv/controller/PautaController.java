package com.br.srv.controller;

import com.br.srv.document.Pauta;
import com.br.srv.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author erik_
 * Data Criacao: 16/07/2021 - 08:41
 */

@RestController
public class PautaController {

    @Autowired
    private PautaService pautaService;

    @GetMapping("/{id}")
    public Mono<Pauta> getPauta(@PathVariable String id){
        return pautaService.buscarComId(id);
    }
}
