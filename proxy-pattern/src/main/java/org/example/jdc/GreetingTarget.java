package org.example.jdc;

public class GreetingTarget implements IGreeting{

    @Override
    public String sayHello(String name) {
        return  "Hello" + name + "!";
    }
}
