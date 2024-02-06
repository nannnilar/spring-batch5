package org.example.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SpringBean1 implements InitializingBean,
        DisposableBean {
    private SpringBean2 springBean2;

    public SpringBean1(){
        System.out.println(this.getClass()
                .getSimpleName()+":: constructor is invoked.");
    }
    @PostConstruct
    public void postConstruct(){
        System.out.println("@PostConstruct is called.");
    }


    @Autowired
    public void setSpringBean2(SpringBean2 springBean2) {
        System.out.println("setting SpringBean2");
        this.springBean2 = springBean2;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet() is called.");
    }

    public void customInit(){
        System.out.println("customInit() is called.");
    }

    public String sayHello(){
        return "Hello!";
    }
    @PreDestroy
    public void preDestroy(){
        System.out.println("@PreDestroy is called.");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy is called.");
    }

    public void customDestroy(){
        System.out.println("customDestory is called.");
    }










}
