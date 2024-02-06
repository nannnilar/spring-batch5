package com.jdc.token.api.exceptions;

import org.springframework.validation.BindingResult;

import java.util.List;

public class ValidationFailureException extends RuntimeException{

    private List<String> messages;

    public ValidationFailureException(BindingResult result){
        messages = result.getFieldErrors().stream()
                .map(a -> a.getDefaultMessage()).toList();
    }

    public List<String > getMessages(){
        return messages;
    }

}
