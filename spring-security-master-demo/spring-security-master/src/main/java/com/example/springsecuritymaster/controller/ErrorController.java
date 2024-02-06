package com.example.springsecuritymaster.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(Throwable.class)
    public ModelAndView handleException(Throwable throwable){
        HttpStatus httpStatus=null;
        String message=null;
        HttpStatusCode httpStatusCode=null;
        if(throwable instanceof EntityNotFoundException){
            httpStatus=HttpStatus.NOT_FOUND;
            httpStatusCode=HttpStatusCode.valueOf(HttpStatus.NOT_FOUND.value());
            message = throwable.getMessage() != null ? throwable.getMessage()
                    : "Unknown Message!";

        }
        if(throwable instanceof HttpServerErrorException.InternalServerError){
            httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
            httpStatusCode=HttpStatusCode.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value());
            message = throwable.getMessage() != null ? throwable.getMessage()
                    : "Unknown Message!";
        }
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("error2");
        modelAndView.addObject("status",httpStatus);
        modelAndView.addObject("msg",message);
        modelAndView.addObject("statusCode",httpStatusCode);
        return modelAndView;
    }
}
