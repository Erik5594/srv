package com.br.srv.service;

import com.br.srv.document.Pauta;
import reactor.core.publisher.Mono;

/**
 * @author erik_
 * Data Criacao: 16/07/2021 - 08:35
 */
public interface PautaService {

    Mono<Pauta> buscarComId(String id);
    Mono<Pauta> salvar(Pauta pauta);

}
