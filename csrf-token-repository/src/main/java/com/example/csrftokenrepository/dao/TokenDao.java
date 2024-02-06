package com.example.csrftokenrepository.dao;

import com.example.csrftokenrepository.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenDao extends JpaRepository<Token,Integer> {

    Optional<Token> findByIdentifier(String identifier);
}
