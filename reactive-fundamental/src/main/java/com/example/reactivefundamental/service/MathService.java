package com.example.reactivefundamental.service;

import com.example.reactivefundamental.dto.Response;
import com.example.reactivefundamental.util.SleepUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MathService {

    public Response square(int input){
        return new Response(input*input);
    }
    public List<Response> multiplicationTable(int input){
        return IntStream.rangeClosed(1,10)
                .peek(i -> SleepUtil.sleep(1))
                .peek(i -> System.out.println("Math Service Processing :: "+i))
                .mapToObj(i -> new Response(i*input))
                .collect(Collectors.toList());
    }
}
