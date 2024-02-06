package com.example.reactivefundamental.dto;

import lombok.Data;

import java.util.Date;
@Data
public class Response {
    private Date date = new Date();
    private int input;
    public Response (int input){
        this.input = input;
    }
}
