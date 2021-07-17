package com.br.srv.service;

import com.br.srv.document.Pauta;
import com.br.srv.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author erik_
 * Data Criacao: 16/07/2021 - 08:38
 */

@Service
public class PautaServiceImpl implements PautaService {

    @Autowired
    private PautaRepository pautaRepository;

    @Override
    public Mono<Pauta> buscarComId(String id) {
        return pautaRepository.findById(id);
    }

    @Override
    public Mono<Pauta> salvar(Pauta pauta) {
        return pautaRepository.save(pauta);
    }
}
