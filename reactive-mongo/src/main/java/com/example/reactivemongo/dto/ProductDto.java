package com.example.reactivemongo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class ProductDto {
    private String id;
    private String description;
    private double price;

    public ProductDto(String description, double price) {
        this.description = description;
        this.price = price;
    }
}
