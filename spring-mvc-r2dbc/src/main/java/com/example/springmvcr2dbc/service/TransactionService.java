package com.example.springmvcr2dbc.service;

import com.example.springmvcr2dbc.dto.TransactionRequestDto;
import com.example.springmvcr2dbc.dto.TransactionResponseDto;
import com.example.springmvcr2dbc.dto.TransactionStatus;
import com.example.springmvcr2dbc.entity.UserTransaction;
import com.example.springmvcr2dbc.repository.UserTransactionRepository;
import com.example.springmvcr2dbc.util.EntityDtoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final UserTransactionRepository userTransactionRepository;

    public Mono<TransactionResponseDto> createTransaction(final TransactionRequestDto requestDto){
       return this.userTransactionRepository.updateUserBalance(requestDto.getUserId(), requestDto.getAmount())
                .filter(Boolean::booleanValue)
                .map(b -> EntityDtoUtil.toEntity(requestDto))
                .flatMap(this.userTransactionRepository::save)
                .map(ut -> EntityDtoUtil.toDto(requestDto,TransactionStatus.APPROVED))
                .defaultIfEmpty(EntityDtoUtil.toDto(requestDto,TransactionStatus.DECLINED));
    }
}
