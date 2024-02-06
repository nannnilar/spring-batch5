package org.example.cglib;

public class Main {
    public static void main(String[] args) {
        MyGreeting greeting = new MyGreetingProxy();
        System.out.println(greeting.formalGreeting("Willaim"));
    }
}
