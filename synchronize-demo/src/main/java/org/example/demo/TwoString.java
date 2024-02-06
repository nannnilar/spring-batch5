package org.example.demo;

public class TwoString {

    public void print(String s1,String s2){
        System.out.println(s1);
        try {
            Thread.sleep(1500);
        } catch (Exception e){
           throw new RuntimeException(e);
        }
        System.out.println(s2);
    }
}
