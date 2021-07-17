package com.br.srv.handler;

import com.br.srv.document.Pauta;
import com.br.srv.service.PautaService;
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

import static org.springframework.web.reactive.function.server.ServerResponse.*;

/**
 * @author erik_
 * Data Criacao: 17/07/2021 - 13:59
 */

@Component
public class PautaHandler {

    @Autowired
    private PautaService pautaService;
    @Qualifier("pauta")
    @Autowired
    private Validator pautaValidator;

    public Mono<ServerResponse> getPauta(ServerRequest request){
        String idPauta = request.pathVariable("id");
        return pautaService.buscarComId(idPauta)
                .flatMap(pauta -> ok().contentType(MediaType.APPLICATION_JSON).bodyValue(pauta))
                .switchIfEmpty(notFound().build());

    }

    public Mono<ServerResponse> cadastrarPauta(ServerRequest request){
        Mono<Pauta> pauta = request.bodyToMono(Pauta.class).doOnNext(this::validar);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(pauta.flatMap(pautaService::salvar), Pauta.class));
    }

    private void validar(Pauta pauta){
        Errors errors = new BeanPropertyBindingResult(pauta, "Pauta");
        pautaValidator.validate(pauta, errors);
        if(errors.hasErrors()){
            throw new ServerWebInputException(errors.toString());
        }
    }
}
