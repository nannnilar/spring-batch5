package org.example.jdc;

public class GreetingProxy implements IGreeting{

    private GreetingTarget greetingTarget;
    public GreetingProxy(GreetingTarget greetingTarget) {
        this.greetingTarget = greetingTarget;
    }

    @Override
    public String sayHello(String name) {
        return "How are you doing?"
                +greetingTarget.sayHello(name);
    }
}
