package com.example.manytoonedemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
//    @JoinColumn(name = "category_id_fk")
    @JoinTable(name = "category_product")
    @ManyToOne
    private Category category;

    public Product() {
    }
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
