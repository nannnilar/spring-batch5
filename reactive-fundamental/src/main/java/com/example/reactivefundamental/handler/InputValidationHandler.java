package com.example.reactivefundamental.handler;

import com.example.reactivefundamental.dto.InputFailValidationResponse;
import com.example.reactivefundamental.exception.InputValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InputValidationHandler {
    @ExceptionHandler(InputValidationException.class)
    public ResponseEntity<InputFailValidationResponse> handleException(InputValidationException e){
//        InputValidationException ex = new InputValidationException(e.getInput());
        InputFailValidationResponse response = new InputFailValidationResponse();
        response.setInput(e.getInput());
        response.setMsg(e.getMessage());
        response.setErrorCode(e.getErrorCode());
        return ResponseEntity.badRequest().body(response);
    }
}
