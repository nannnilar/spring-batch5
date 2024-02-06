package org.example;

import org.example.bean.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.bean")
public class AppConfig {

   /* @Bean
    public Student student() {
       Student s = new Student();
       s.setSchool("Latha");
       s.setAge(22);
       s.setName("Thomas Hardy");
        return s;
    }*/
}
