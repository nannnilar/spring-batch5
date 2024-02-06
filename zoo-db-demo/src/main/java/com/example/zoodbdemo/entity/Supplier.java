package com.example.zoodbdemo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Supplier extends IdClass{
    private String supplierName;
    private String contactNum;
    private String address;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<FoodItem> foodItems = new ArrayList<>();

    public void addFoodItem(FoodItem foodItem){
        foodItem.setSupplier(this);
        foodItems.add(foodItem);
    }

    public Supplier() {
    }

    public Supplier(String supplierName, String contactNum, String address) {
        this.supplierName = supplierName;
        this.contactNum = contactNum;
        this.address = address;
    }
}
