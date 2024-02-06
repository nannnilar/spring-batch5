package org.example.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter @Setter
@AllArgsConstructor
@ToString
public class Employee {

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private Date start_date;
    private double salary;
}
