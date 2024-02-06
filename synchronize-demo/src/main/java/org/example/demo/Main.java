package org.example.demo;

import org.example.demo.MyThreadClass;

public class Main {
    public static void main(String[] args) {
        TwoString twoString = new TwoString();
        MyThreadClass obj1 = new MyThreadClass("Hi","John",twoString);
        MyThreadClass obj2 = new MyThreadClass("Hello","William",twoString);
        MyThreadClass obj3 = new MyThreadClass("Happy","Coding",twoString);
        MyThreadClass obj4 = new MyThreadClass("Things of","Beauty",twoString);
    }

}