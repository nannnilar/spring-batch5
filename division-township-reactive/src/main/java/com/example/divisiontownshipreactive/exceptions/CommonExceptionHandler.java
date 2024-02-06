package com.example.divisiontownshipreactive.exceptions;

import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionHandler extends RuntimeException{

    ErrorResponse handle(LocationAppException e){
        return new
    }
}
