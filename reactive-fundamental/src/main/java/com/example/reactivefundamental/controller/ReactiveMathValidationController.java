package com.example.reactivefundamental.controller;

import com.example.reactivefundamental.dto.Response;
import com.example.reactivefundamental.exception.InputValidationException;
import com.example.reactivefundamental.service.ReactiveMathService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ReactiveMathValidationController {
    private final ReactiveMathService service;

    @GetMapping("/math/reactive/square/{input}/throw")
    public Mono<Response> square(@PathVariable int input){
        if (input < 10 || input >20){
            throw new InputValidationException(input);
        }
        return service.square(input);
    }
    @GetMapping("/square/{input}/mono-error")
    public Mono<Response> squareHandlerError(@PathVariable int input){
        return Mono.just(input).handle((integer,sink) ->{
            if (integer >=10 && integer <=20){
                sink.next(integer);
            }
            else {
                sink.error(new InputValidationException(integer));
            }
        }).cast(Integer.class)
                .flatMap(i -> this.service.square(i));
    }
//    10-20 send its response, else 400 bad request, no exception,no error signal, no controller advice
    @GetMapping("/square/{input}/assignment")
    public Mono<ResponseEntity<Response>> assignment(@PathVariable int input){
        return Mono.just(input)
                .filter(a -> a >= 10 && a <= 20)
                .flatMap(i -> service.square(i))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }
}
