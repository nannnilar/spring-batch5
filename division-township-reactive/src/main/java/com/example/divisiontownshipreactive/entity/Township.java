package com.example.divisiontownshipreactive.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
@SequenceGenerator(name = "seq_township",allocationSize = 1)
public class Township {

    @Id
    @GeneratedValue(generator = "seq_township",strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @ManyToOne(optional = false)
    private Division division;

    public Township() {
    }

    public Township(String name) {
        this.name = name;
    }

    public Township(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
