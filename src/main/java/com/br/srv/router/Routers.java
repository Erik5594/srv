package com.br.srv.router;

import com.br.srv.handler.PautaHandler;
import com.br.srv.handler.VotoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

/**
 * @author erik_
 * Data Criacao: 17/07/2021 - 14:02
 */

@Configuration
public class PautaRouter {

    @Bean
    public RouterFunction<ServerResponse> route(PautaHandler pautaHandler, VotoHandler votoHandler){

        return RouterFunctions.route(
                RequestPredicates.GET("/pauta/{id}")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), pautaHandler::getPauta
        ).andRoute(RequestPredicates.POST("/pauta")
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), pautaHandler::cadastrarPauta
        ).andRoute(
                RequestPredicates.POST("/voto")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), votoHandler::registrarVoto
        );

    }

}
