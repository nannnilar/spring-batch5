package com.example.carinsurance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
@Entity
public class CarManufacturar extends Company{
    private String numberOfEmployees;
    private LocalDate YearEstablished;
    @OneToOne(mappedBy = "carManufacturar")
    private Car car;
}
