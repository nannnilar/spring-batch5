package org.example.jdc;

public class Main {
    public static void main(String[] args) {
        IGreeting iGreeting = new GreetingProxy((new GreetingTarget()));
        System.out.println(iGreeting.sayHello(" John Doe"));
    }
}
