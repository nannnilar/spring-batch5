package com.example.springmvcr2dbc.repository;

import com.example.springmvcr2dbc.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User,Integer> {
}
