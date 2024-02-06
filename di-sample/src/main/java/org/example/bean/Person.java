package org.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Person {

    private String name = "John Doe";

    @Autowired
    private  IAddress address;

    public Person(Address1 address) {
        System.out.println("Address in Constructor: " + address);
    }
    @PostConstruct
    public void init() {
        System.out.println("Address in PostContructor: " +address);
    }


    public Person(String name, Address1 address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String personInfo(){
        return String.format(
                "%s lives in %s.",
                name,address.getCity()
        );
    }
}
