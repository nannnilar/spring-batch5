package org.example.bean;

import org.springframework.stereotype.Component;

@Component("my_address1")
public class Address1 implements IAddress {
    private String city = "Yangon";

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
