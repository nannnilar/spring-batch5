package com.demo.printer;

public class DecorateValuePrinter implements ValuePrinter{
    @Override
    public void print(int i) {
        System.out.println(
                String.format("The value is : [%d]",i)
        );
    }
}
