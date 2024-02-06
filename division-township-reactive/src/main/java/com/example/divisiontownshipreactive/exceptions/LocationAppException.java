package com.example.divisiontownshipreactive.exceptions;

import java.util.List;

public class LocationAppException extends RuntimeException{

    private Type type;
    private List<String>
    private enum Type{
        BUSINESS,VALIDATION
    }


}
