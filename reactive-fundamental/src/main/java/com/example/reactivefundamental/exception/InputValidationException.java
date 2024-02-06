package com.example.reactivefundamental.exception;

public class InputValidationException extends RuntimeException{

    private static final String msg = "Allowed range is 10 -20";
    private static final int errorCode = 100;
    private final int input;

    public InputValidationException(int input){
        super(msg);
        this.input = input;
    }

    public int getInput(){
        return input;
    }

    public int getErrorCode(){
        return errorCode;
    }
}
