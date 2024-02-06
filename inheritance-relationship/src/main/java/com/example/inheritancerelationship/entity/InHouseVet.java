package com.example.inheritancerelationship.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("in_vet")
public class InHouseVet extends Vet{
    private double salary;

    public InHouseVet() {
    }

    public InHouseVet(String name, String qualification, double salary) {
        super(name, qualification);
        this.salary = salary;
    }
}
