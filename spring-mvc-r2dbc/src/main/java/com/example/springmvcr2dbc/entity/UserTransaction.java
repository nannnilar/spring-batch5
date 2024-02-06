package com.example.springmvcr2dbc.entity;

import io.r2dbc.spi.Parameter;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@ToString
public class UserTransaction {
    @Id
    private Integer id;
    private Integer userId;
    private Integer amount;
    private LocalDate transactionDate;

}
