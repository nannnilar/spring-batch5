package com.example.springmvcr2dbc.dto;

import io.r2dbc.spi.Parameter;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TransactionResponseDto {

    private Integer userId;
    private Integer amount;
    private TransactionStatus status;
}
