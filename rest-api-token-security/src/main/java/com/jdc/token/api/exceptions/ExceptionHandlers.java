package com.jdc.token.api.exceptions;

import com.jdc.token.model.ErrorResponse;
import com.jdc.token.model.ErrorResponse.Type;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlers {
    private final Map<Class<? extends AuthenticationException>,String> authenticationErrors = Map.of(
            UsernameNotFoundException.class,"Please check your login id.",
            BadCredentialsException.class,"Please check your password."
    );
    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN)
    ErrorResponse handle(AuthenticationException e){
        var message = authenticationErrors.get(e.getClass());
        return new ErrorResponse(Type.Authentication, List.of(null != message ? message : "Authentication Error!"));
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse handle(ValidationFailureException e){
        return new ErrorResponse(Type.Authorization, List.of(e.getMessage()));
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN)
    ErrorResponse handle(AccessDeniedException e){
        return new ErrorResponse(Type.Authorization,List.of("You have no permission for this operation"));
    }


}
