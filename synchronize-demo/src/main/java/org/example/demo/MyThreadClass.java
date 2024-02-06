package org.example.demo;

import java.util.concurrent.Executor;

public class MyThreadClass extends Thread{
    private String s1;
    private String s2;
    private TwoString twoString;


    public MyThreadClass(String s1,String s2, TwoString twoString){
        this.s1 = s1;
        this.s2 = s2;
        this.twoString = twoString;
        start();
    }


    @Override
    public void run() {

        synchronized (twoString) {
            twoString.print(s1, s2);
        }
    }
}
