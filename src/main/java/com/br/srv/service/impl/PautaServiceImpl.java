package com.br.srv.service.impl;

import com.br.srv.document.Pauta;
import com.br.srv.repository.PautaRepository;
import com.br.srv.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Calendar;
import java.util.Date;

/**
 * @author erik_
 * Data Criacao: 16/07/2021 - 08:38
 */

@Service
public class PautaServiceImpl implements PautaService {

    private static int SEGUNDOS_DEFAULT = 60;
    private static int TEMPO_LIMITE = 18000;

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

    @Override
    public Mono<Pauta> abrirSessao(Pauta pauta, int segundos) {
        pauta.setInicioSessao(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, getSegundos(segundos));
        pauta.setFimSessao(calendar.getTime());
        return salvar(pauta);
    }

    private int getSegundos(int segundos){
        return segundos <= 0 ? SEGUNDOS_DEFAULT : segundos > TEMPO_LIMITE ? TEMPO_LIMITE:segundos;
    }
}
