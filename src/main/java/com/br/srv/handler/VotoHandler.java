package com.br.srv.handler;

import com.br.srv.document.Voto;
import com.br.srv.service.VotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author erik_
 * Data Criacao: 17/07/2021 - 21:26
 */

@Component
public class VotoHandler {

    @Autowired
    private VotacaoService service;

    @Qualifier("voto")
    @Autowired
    private Validator validador;

    public Mono<ServerResponse> registrarVoto(ServerRequest request){
        Mono<Voto> voto = request.bodyToMono(Voto.class).doOnNext(this::validar);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(voto.flatMap(service::registrarVoto), Voto.class));
    }

    private void validar(Voto voto){
        Errors errors = new BeanPropertyBindingResult(voto, "Voto");
        validador.validate(voto, errors);
        if(errors.hasErrors()){
            throw new ServerWebInputException(errors.toString());
        }
    }
}
