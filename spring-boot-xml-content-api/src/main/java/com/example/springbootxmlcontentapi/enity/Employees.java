package com.example.springbootxmlcontentapi.enity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Getter
@Setter
@ToString
@JacksonXmlRootElement
public class Employees implements Serializable {
    private List<Employee> employees = new ArrayList<>();
    public Employees(Iterable<Employee> employeeIterable){
        employees = StreamSupport.stream(employeeIterable.spliterator(),
                false).collect(Collectors.toList());
    }

    public Employees(){}
}
