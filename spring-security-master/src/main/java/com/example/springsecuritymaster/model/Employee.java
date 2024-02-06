package com.example.springsecuritymaster.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "First Name cannot be empty!")
    @Pattern(regexp = "[A-Za-z-']*", message = "First Name cannot contain illegal character!")
    private String firstName;

    @NotEmpty(message = "Last Name cannot be empty!")
    @Pattern(regexp = "[A-Za-z-']*", message = "Last Name cannot contain illegal character!")
    private String lastName;

    @Pattern(regexp = "[0-9\\-+]*", message = "Phone Number is not valid!")
    private String phoneNumber;

    @NotEmpty(message = "Address cannot be empty!")
    @Pattern(regexp = "[\\w .\\-/,]*", message = "Address cannot contain illegal characters!")
    private String address;

    @NotBlank(message = "Cubicle Number cannot be blank!")
    @Pattern(regexp = "[A-Za-z0-9\\-]*", message = "Cubicle Number cannot contain illegal characters!")
    private String cubicleNo;
}
