package com.example.csrftokenrepository.csrf;

import com.example.csrftokenrepository.dao.TokenDao;
import com.example.csrftokenrepository.entity.Token;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CustomCsrfTokenRepository implements CsrfTokenRepository {

    private final TokenDao tokenDao;

    public CustomCsrfTokenRepository(TokenDao tokenDao) {
        this.tokenDao = tokenDao;
    }

    @Override
    public CsrfToken generateToken(HttpServletRequest request) {
        String uuid = UUID.randomUUID().toString();

        return new DefaultCsrfToken("X-CSRF-TOKEN","_csrf",uuid);
    }

    @Override
    public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {
        String identifier = request.getHeader("X-IDENTIFIER");
        Optional<Token> existingToken = tokenDao.findByIdentifier(identifier);
        if (existingToken.isPresent()){
            Token token1 = existingToken.get();
            token1.setToken(token.getToken());
        } else {
            Token token1 = new Token();
            token1.setIdentifier(identifier);
            token1.setToken(token.getToken());
            tokenDao.save(token1);
        }
    }

    @Override
    public CsrfToken loadToken(HttpServletRequest request) {
       String identifier = request.getHeader("X-IDENTIFIER");
       Optional<Token> existingToken = tokenDao.findByIdentifier(identifier);
       if (existingToken.isPresent()) {
           Token token = existingToken.get();
           return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", token.getToken());
       }
       return null;
    }
}
