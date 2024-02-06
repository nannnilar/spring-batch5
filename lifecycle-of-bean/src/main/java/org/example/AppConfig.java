package org.example;

import org.example.bean.SpringBean1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ComponentScan
@Configuration
public class AppConfig {

    @Bean(initMethod = "customInit" ,destroyMethod = "customDestroy")
    public SpringBean1 springBean1() {
        return new SpringBean1();
    }

    @Bean
    public static CustomBeanFactoryPostProcessor customBeanFactoryPostProcessor() {
        return new CustomBeanFactoryPostProcessor();
    }

    @Bean
    public static CustomBeanPostProcessor beanPostProcessor() {

        return new CustomBeanPostProcessor();
    }
}
