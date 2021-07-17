package com.br.srv.repository;

import com.br.srv.document.Pauta;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author erik_
 * Data Criacao: 16/07/2021 - 08:22
 */
public interface PautaRepository extends ReactiveMongoRepository<Pauta, String> {

}
