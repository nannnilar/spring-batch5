package com.example.reactivemongo.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Product {
    private String id;
    private String description;
    private double price;
}
