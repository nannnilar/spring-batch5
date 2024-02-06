package com.example.springmvcr2dbc.repository;

import com.example.springmvcr2dbc.entity.UserTransaction;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserTransactionRepository extends ReactiveCrudRepository<UserTransaction,Integer> {
    @Modifying
    @Query("""
    update users set balance = balance - :amount where id = :userId
    and balance >= :amount
""")

    Mono<Boolean> updateUserBalance(int userId, int amount);
}
