package com.example.defaultrollbackpolicy.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
