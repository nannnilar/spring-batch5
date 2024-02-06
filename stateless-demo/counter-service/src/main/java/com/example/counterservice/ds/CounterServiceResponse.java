package com.example.counterservice.ds;

import lombok.Getter;

@Getter
public class CounterServiceResponse {

    private int number;

    public CounterServiceResponse(int number) {
        this.number = number;
    }
}
