package com.example.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Data
@AllArgsConstructor
public class Employees {

    private List<Employee> employees;

    public Employees() {
    }

    public Employees(Spliterator<Employee> spliterator){
        employees = StreamSupport.stream(spliterator,false).collect(Collectors.toList());
    }
}
