package com.jdc.token.api;

import com.jdc.token.model.LoginForm;
import com.jdc.token.model.LoginResult;
import com.jdc.token.service.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public")
@RequiredArgsConstructor
public class PublicApi {
    @Autowired
    private final  AuthenticationManager authenticationManager;
    @Autowired
    private final TokenProvider tokenProvider;

    @PostMapping("login")
    LoginResult login(@Validated LoginForm form , BindingResult result){
//        create authentication for authentication process
//        var authentication = UsernamePasswordAuthenticationToken.unauthenticated(form.username(),form.password());
        var authentication = authenticationManager.authenticate(form.authentication());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        var token = tokenProvider.generate(authentication);
        if (null != token){
            return new LoginResult(true,token);
        }
        return new LoginResult(false,"Authentication Failure");
    }
}
