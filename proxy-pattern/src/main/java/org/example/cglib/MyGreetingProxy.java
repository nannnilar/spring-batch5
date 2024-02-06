package org.example.cglib;

public class MyGreetingProxy extends MyGreeting{

    @Override
    public String formalGreeting(String name) {
        return "How are you doing?"+super.formalGreeting(name);
    }
}
