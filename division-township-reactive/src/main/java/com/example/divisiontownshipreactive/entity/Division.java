package com.example.divisiontownshipreactive.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@SequenceGenerator(name = "seq_division",allocationSize = 1)
public class Division {

    @Id
    @GeneratedValue(generator = "seq_division",strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false)
    private String name;
    @Column(nullable = false)
    private String region;
    @OneToMany
    private List<Township> townships = new ArrayList<>();

    public Division() {
    }

    public Division(String name, String region) {
        this.name = name;
        this.region = region;
    }

    public Division(int id, String name, String region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }
}
