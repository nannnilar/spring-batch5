package com.example.reactivefundamental.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class InputFailValidationResponse {
    private int errorCode;
    private String msg;
    private int input;
}
