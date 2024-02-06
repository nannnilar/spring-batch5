package com.example.affablebeanerd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String city_regoin;
    private String cityCodeNumber;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.PERSIST)
    private List<CustomerOrder> customerOrders = new ArrayList<>();

    public void addCustomerOrder(CustomerOrder customerOrder){
        customerOrder.setCustomer(this);
        this.customerOrders.add(customerOrder);
    }
    public Customer() {
    }
    public Customer(String name, String email, String phoneNumber, String address, String city_regoin, String cityCodeNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city_regoin = city_regoin;
        this.cityCodeNumber = cityCodeNumber;
    }
}
