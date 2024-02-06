package org.example.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpringBean1 {
    @Value("#{'${app.city}'.toUpperCase()}")
    private String city;
    @Value("#{${app.id}*2}")
    private int id;
    @Value("${app.name}")
    public String appName;
    @Value("#{T(java.lang.Integer).toBinaryString(${app.id})}")
    private List<String> list;
    @Value("#{T(java.lang.Integer).toBinaryString(${app.test})}")
    private String binaryString;
    @Value("#{bean2.taxCount}")
    private int mytaxCount;

    public void print() {
        System.out.println("City:"+city);
        System.out.println("Id:"+id);
        System.out.println("Name"+appName);
        System.out.println("Count:"+list);
        System.out.println("Test:"+binaryString);
        System.out.println("MyTestCount:"+mytaxCount);
    }
}
