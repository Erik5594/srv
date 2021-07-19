package com.br.srv.repository;

import com.br.srv.document.Voto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * @author erik_
 * Data Criacao: 17/07/2021 - 21:30
 */
public interface VotoRepository extends ReactiveMongoRepository<Voto, String> {

    <S extends Voto> Flux<S> findVotoByAssociado_CnpjCpf(String cpf);
}
