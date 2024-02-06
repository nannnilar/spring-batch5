package com.example.reactivefundamental.controller;

import com.example.reactivefundamental.dto.MultiplyRequestDto;
import com.example.reactivefundamental.dto.Response;
import com.example.reactivefundamental.exception.InputValidationException;
import com.example.reactivefundamental.service.ReactiveMathService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.AbstractJackson2Decoder;
import org.springframework.http.codec.json.AbstractJackson2Encoder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ReactiveMathController {
    private final ReactiveMathService service;

    @GetMapping("/math/reactive/square/{input}")
    public Mono<Response> square(@PathVariable int input){
        if (input < 10 || input >20){
            throw new InputValidationException(input);
        }
        return service.square(input);
    }
    @GetMapping(value = "/math/reactive/table/{input}/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Response> multiplicationStream(@PathVariable int input){
        return service.multiplication(input);
    }

    @GetMapping(value = "/math/reactive/table/{input}")
    public Flux<Response> multiplication(@PathVariable int input){
        AbstractJackson2Encoder end;
        return service.multiplication(input);
    }
    @GetMapping(value = "/math/reactive/table/{input}/not",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Response> multiplicationNot(@PathVariable int input){
        return service.muitiplicationNotReactive(input);
    }
    @PostMapping("/math/reactive/multiply")
    public Mono<Response> getMultiply(@RequestBody Mono<MultiplyRequestDto> multiplyRequestDtoMono,
                                        @RequestHeader Map<String,String> headers) {
        System.out.println(headers);
        return service.multiply(multiplyRequestDtoMono);

    }
}
