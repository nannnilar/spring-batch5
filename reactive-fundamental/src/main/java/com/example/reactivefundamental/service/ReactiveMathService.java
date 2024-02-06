package com.example.reactivefundamental.service;

import com.example.reactivefundamental.dto.MultiplyRequestDto;
import com.example.reactivefundamental.dto.Response;
import com.example.reactivefundamental.util.SleepUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ReactiveMathService {

    public Mono<Response> square(int input){
        return Mono.just(new Response(input * input));
    }

    public Flux<Response> multiplication(int input){
        return Flux.range(1,10)
//                .doOnNext(i -> SleepUtil.sleep(1))
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Math Reactive Service Processing :: "+i))
                .map(i -> new Response(i*input));
    }

    public Flux<Response> muitiplicationNotReactive(int input){
        List<Response> responses = IntStream.rangeClosed(1,10)
                .peek(i -> SleepUtil.sleep(1))
                .peek(i -> System.out.println("Math Service Processing :: "+i))
                .mapToObj(i -> new Response(i*input))
                .collect(Collectors.toList());
        return Flux.fromIterable(responses);
    }

    public Mono<Response> multiply(Mono<MultiplyRequestDto> multiplyRequestDtoMono) {
        return multiplyRequestDtoMono
                .map(m -> m.getFirst() * m.getSecond())
                .map(Response::new);

    }
}
