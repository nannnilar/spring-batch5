package org.example.service;

import org.springframework.stereotype.Component;

@Component
public class MyStudentService {
    void playFootball(){}

    public void goShool(){
        playFootball();
        takeExam();
    }
    protected void takeExam(){}

}
