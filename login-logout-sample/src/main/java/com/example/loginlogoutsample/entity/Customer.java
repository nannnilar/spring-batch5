package com.example.loginlogoutsample.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name",unique = true)
    private String userName;
    private String password;
    private String phoneNumber;
    private String email;
    @Transient
    private String roleName;
    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Set<Roles> roles = new HashSet<>();

    @Override
    public String toString(){
        return userName;
    }

}
