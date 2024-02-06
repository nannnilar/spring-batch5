package org.example.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component @Lazy(value = true)
public class SpringBean3 {
    public SpringBean3() {
        System.out.println(this.getClass().getSimpleName()+ "::Constructor");
    }
}
