package com.example.carinsurance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Owner extends Person{
    @ManyToOne
    private Car car;
}
