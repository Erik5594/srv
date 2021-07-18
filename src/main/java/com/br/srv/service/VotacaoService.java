package com.br.srv.service;

import com.br.srv.document.Voto;
import reactor.core.publisher.Mono;

/**
 * @author erik_
 * Data Criacao: 17/07/2021 - 21:23
 */
public interface VotacaoService {
    Mono<Voto> registrarVoto(Voto voto);
}
