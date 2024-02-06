package com.example.prepostfilter.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class Product {

    private String owner;
    private List<String> items;
}
