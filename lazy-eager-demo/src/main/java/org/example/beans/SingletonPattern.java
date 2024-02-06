package org.example.beans;

class MyClass{
    private static MyClass myClass;
    private MyClass(){}

    public static MyClass getMyClass(){
        if (myClass == null){
            myClass = new MyClass();
        }
        return myClass;
    }
}
public class SingletonPattern {

    public static void main(String[] args) {
        MyClass myClass =  MyClass.getMyClass();
        MyClass myClass1 =  MyClass.getMyClass();
        MyClass myClass2 =  MyClass.getMyClass();
        System.out.println(myClass);
        System.out.println(myClass1);
        System.out.println(myClass2);
        boolean test = myClass.equals(myClass1);
        System.out.println(test);
    }
}
