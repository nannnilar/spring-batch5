package com.example.springmvcr2dbc.util;

import com.example.springmvcr2dbc.dto.TransactionRequestDto;
import com.example.springmvcr2dbc.dto.TransactionResponseDto;
import com.example.springmvcr2dbc.dto.TransactionStatus;
import com.example.springmvcr2dbc.dto.UserDto;
import com.example.springmvcr2dbc.entity.User;
import com.example.springmvcr2dbc.entity.UserTransaction;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

public class EntityDtoUtil {

    public static UserDto toDto(User user){
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user,dto);
        return dto;
    }

    public static User toEntity(UserDto dto){
        User user = new User();
        BeanUtils.copyProperties(dto,user);
        return user;
    }
    public static UserTransaction toEntity(TransactionRequestDto requestDto){
        UserTransaction ut = new UserTransaction();
        ut.setId(requestDto.getUserId());
        ut.setAmount(requestDto.getAmount());
        ut.setTransactionDate(LocalDate.now());
        return ut;
    }
    public static TransactionResponseDto toDto(TransactionRequestDto requestDto, TransactionStatus status){
        TransactionResponseDto responseDto = new TransactionResponseDto();
        responseDto.setAmount(requestDto.getAmount());
        responseDto.setUserId(requestDto.getUserId());
        responseDto.setStatus(status);
        return responseDto;
    }
}
