package org.example.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("bean2")
public class SpringBean2 {
    @Value("5")
    public int taxCount;
}
