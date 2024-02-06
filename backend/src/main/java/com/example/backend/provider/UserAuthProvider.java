package com.example.backend.provider;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.backend.data.UserDto;
import com.example.backend.entities.User;
import com.example.backend.exception.AppException;
import com.example.backend.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import static com.example.backend.service.UserService.*;


@Component
@RequiredArgsConstructor
public class UserAuthProvider {

    @Value("${security.jwt.token.secret}")
    private String secretKey;

    private final UserRepository userRepository;

    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(UserDto userDto){
        Date now = new Date();
        Date validation = new Date(now.getTime() + 3_600_000);

        return JWT.create()
                .withIssuer(userDto.getToken())
                .withIssuedAt(now)
                .withExpiresAt(validation)
                .withClaim("firstName",userDto.getFirstName())
                .withClaim("lastNAme",userDto.getLastName())
                .sign(Algorithm.HMAC256(secretKey));
    }

    public Authentication validationToken(String token){
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        JWTVerifier verifier = JWT.require(algorithm).build();
        verifier.verify(token);
        DecodedJWT decodedJWT = verifier.verify(token);
        UserDto userDto = UserDto.builder()
                .login(decodedJWT.getIssuer())
                .firstName(decodedJWT.getClaim("firstName").asString())
                .lastName(decodedJWT.getClaim("lastName").asString())
                .build();

        return new UsernamePasswordAuthenticationToken(userDto,null, Collections.emptyList());
    }

    public Authentication validateTokenStrongly(String token){
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT= verifier.verify(token);
        User user =  userRepository.findByLogin(decodedJWT.getIssuer())
                .orElseThrow(() -> new AppException("Unknown User", HttpStatus.NOT_FOUND));
        return new UsernamePasswordAuthenticationToken(
                toDto(user),
                null,
                Collections.emptyList()
        );
    }

}
