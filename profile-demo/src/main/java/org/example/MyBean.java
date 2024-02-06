package org.example;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component @Profile("test")
public class MyBean {
    public MyBean() {
        System.out.println(this.getClass().getSimpleName()+"::constructor");
    }
}
