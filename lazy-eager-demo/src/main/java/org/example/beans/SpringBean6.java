package org.example.beans;

import org.springframework.beans.factory.annotation.Value;

public class SpringBean6 {
    @Value("${my.app.name}")
    private String appName;
    @Value("${JAVA_HOME}")
    private String javaHome;
    @Value("${vm.value}")
    private String vmProperties;
    public SpringBean6() {
        System.out.println(this.getClass().getSimpleName()+ "::Constructor");
    }
    public void print() {
        System.out.println("AppName:"+appName);
        System.out.println("JavaHome:"+javaHome );
        System.out.println("VM:"+vmProperties);
    }
}
