package com.example.reactivefundamental.config;

import com.example.reactivefundamental.dto.Response;
import com.example.reactivefundamental.service.ReactiveMathService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RequestHandler {

    private final ReactiveMathService service;

    public Mono<ServerResponse> squareHandler(ServerRequest request){
        int data = Integer.parseInt(request.pathVariable("input"));
       Mono<Response> responseMono = service.square(data);
       return ServerResponse.ok().body(responseMono, Response.class);
    }
    public Mono<ServerResponse> tableHandler(ServerRequest request){
        int data = Integer.parseInt(request.pathVariable("input"));
        Flux<Response> responseFlux  = service.multiplication(data);
        return ServerResponse.ok().body(responseFlux, Response.class);

    }

    public Mono<ServerResponse> tableHandlerStream(ServerRequest request){
        int data = Integer.parseInt(request.pathVariable("input"));
        Flux<Response> responseFlux  = service.multiplication(data);
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(responseFlux, Response.class);

    }
}
