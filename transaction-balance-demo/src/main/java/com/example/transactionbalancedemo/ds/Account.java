package com.example.transactionbalancedemo.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Account {

    private int id;
    private String name;
    private int amount;


}
