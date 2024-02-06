package com.example.zoodbdemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Animal extends IdClass{
    private String type;
    private int totalNum;
    @OneToOne(mappedBy = "animal")
    private Cage cage;
    @ManyToOne
    private Category category;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<FoodItem> foodItems = new ArrayList<>();

    public void addFoodItem(FoodItem foodItem){
        foodItem.getAnimals().add(this);
        foodItems.add(foodItem);
    }

    public Animal() {
    }

    public Animal(String type, int totalNum) {
        this.type = type;
        this.totalNum = totalNum;
    }
}
