package com.br.srv.service.impl;

import com.br.srv.document.Voto;
import com.br.srv.repository.VotoRepository;
import com.br.srv.service.VotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author erik_
 * Data Criacao: 17/07/2021 - 21:30
 */
@Service
public class VotacaoServiceImpl implements VotacaoService {

    @Autowired
    private VotoRepository repository;

    @Override
    public Mono<Voto> registrarVoto(Voto voto) {
        return repository.save(voto);
    }
}
