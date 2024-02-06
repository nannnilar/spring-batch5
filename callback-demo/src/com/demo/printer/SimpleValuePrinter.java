package com.demo.printer;

public class SimpleValuePrinter implements ValuePrinter{
    @Override
    public void print(int i) {
        System.out.println(i);
    }
}
