package com.example.jpa_onetoone.ds;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastName;
    private String email;
    @PrimaryKeyJoinColumn
    @OneToOne(mappedBy = "customer",cascade = CascadeType.PERSIST)
    private Address address;

    public Customer() {
    }

    public void addAddress(Address address) {
        address.setCustomer(this);
        this.address = address;
    }

    public Customer(String firstname, String lastName, String email) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
    }
}
