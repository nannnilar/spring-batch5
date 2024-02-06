package com.example.carinsurance.entity;

import jakarta.persistence.Entity;

@Entity
public class InsuranceCompany extends Company{
    private int rating;
}
