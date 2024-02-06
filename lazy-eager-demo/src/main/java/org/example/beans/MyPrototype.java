package org.example.beans;

public class MyPrototype implements IPrototype{
    private String name;

    public MyPrototype(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public IPrototype clone() {
        IPrototype iPrototype = new MyPrototype("");
        try {
             iPrototype = (IPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
