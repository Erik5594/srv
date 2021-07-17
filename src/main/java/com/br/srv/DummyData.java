package com.br.srv;

import com.br.srv.document.Pauta;
import com.br.srv.repository.PautaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

/**
 * @author erik_
 * Data Criacao: 16/07/2021 - 08:23
 */

/*@Component
public class DummyData implements CommandLineRunner {

    private final PautaRepository pautaRepository;

    DummyData(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        pautaRepository.deleteAll()
                .thenMany(
                        Flux.just("Teste 1", "Teste 2", "Teste 3", "Teste 4", "Teste 5")
                        .map(assunto -> new Pauta(UUID.randomUUID().toString(), assunto))
                        .flatMap(pautaRepository::save)
                ).subscribe(System.out::println);
    }
}*/
