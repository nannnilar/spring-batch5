package com.example.reactivefundamental.controller;

import com.example.reactivefundamental.dto.Response;
import com.example.reactivefundamental.service.MathService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MathController {

    private final MathService mathService;
    @GetMapping("/math/square/{input}")
    public Response findSquare(@PathVariable int input){
        return mathService.square(input);
    }
    @GetMapping("/math/table/{input}")
    public List<Response> multiplicationTable(@PathVariable int input){
        return mathService.multiplicationTable(input);
    }
}
