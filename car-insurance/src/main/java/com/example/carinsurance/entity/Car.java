package com.example.carinsurance.entity;

import com.example.carinsurance.dao.CarDao;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String propertyModel;
    private String propertyMake;
    private int year;
    private String Millage;
    @OneToOne(mappedBy = "car")
    private CarManufacturar carManufacturar;
    @OneToMany
    private List<Owner> owners;
    @OneToMany
    private List<Drivers> drivers;
}
