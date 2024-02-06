package com.example.carinsurance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Drivers extends Person{
    @ManyToOne
    private Car car;
}
