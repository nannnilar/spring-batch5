package com.example.counterservice.controller;

import com.example.counterservice.ds.CounterServiceResponse;
import com.example.counterservice.service.MutableCounter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter/stateful")
@RequiredArgsConstructor
public class StatefulCounterController {

    private final MutableCounter mutableCounter;

    @PostMapping("/countUp")
    public CounterServiceResponse countUp(){
        mutableCounter.countUp();
        return new CounterServiceResponse(mutableCounter.getNumber());
    }
}
