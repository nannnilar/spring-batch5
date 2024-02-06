package org.example;

import org.example.beans.SpringBean4;
import org.example.beans.SpringBean5;
import org.example.beans.SpringBean6;
import org.springframework.context.annotation.*;

@PropertySource("classpath:application.properties")
@ComponentScan(lazyInit = true)
@Configuration
public class AppConfig {
    @Bean
    public SpringBean6 springBean6() {
        return new SpringBean6();
    }
    @Bean @Lazy(value = true)
    public SpringBean5 springBean5() {
        return new SpringBean5();
    }

    @Bean
    public SpringBean4 springBean4() {
        return new SpringBean4();
    }

}
