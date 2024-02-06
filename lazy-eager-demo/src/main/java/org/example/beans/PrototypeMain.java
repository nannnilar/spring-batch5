package org.example.beans;

public class PrototypeMain {
    public static void main(String[] args) {
        MyPrototype myPrototype = new MyPrototype("John Doe");
        System.out.println(myPrototype);

        MyPrototype cloneMyProtoype = (MyPrototype) myPrototype.clone();
        System.out.println(cloneMyProtoype);

        System.out.println(myPrototype == cloneMyProtoype);
    }
}
