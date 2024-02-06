package com.example.backend.controller;

import com.example.backend.data.UserDto;
import com.example.backend.dto.CredentialsDto;
import com.example.backend.dto.SignupDto;
import com.example.backend.provider.UserAuthProvider;
import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final UserAuthProvider userAuthProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody CredentialsDto credentialsDto){
        System.out.println("================"+credentialsDto);
        UserDto user = userService.login(credentialsDto);
        user.setToken(userAuthProvider.createToken(user));
        return ResponseEntity.ok(user);
    }
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody SignupDto signupDto){
        System.out.println("================="+signupDto);
        UserDto userDto = userService.register(signupDto);
        return ResponseEntity.created(URI.create("/users/"+userDto.getId()))
                .body(userDto);

    }
}
