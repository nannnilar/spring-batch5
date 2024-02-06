package com.example.loginlogoutsample.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @PrePersist
    public void perPersists(){
        name = "ROLE_".concat(name);
    }

    @Override
    public String toString(){
        return name;
    }
}
