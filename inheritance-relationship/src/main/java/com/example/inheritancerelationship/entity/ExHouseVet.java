package com.example.inheritancerelationship.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("ex_vet")
public class ExHouseVet extends Vet{
    private String country;
    private double visitingFees;

    public ExHouseVet() {
    }

    public ExHouseVet(String name, String qualification, String country, double visitingFees) {
        super(name, qualification);
        this.country = country;
        this.visitingFees = visitingFees;
    }
}
