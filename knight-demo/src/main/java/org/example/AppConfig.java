package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class AppConfig {
   /* @Bean
    public Knight knight(Quest greatMatrimonyQuest){
        Knight knight = new Knight(greatMatrimonyQuest);
        return knight;
    }
    @Bean
    public GreatMatrimonyQuest greatMatrimonyQuest(){
        return new GreatMatrimonyQuest();
    }
    @Bean
    public KillDragonQuest killDragonQuest(){
        return new KillDragonQuest();
    }
    @Bean(name = "yoyeyo")
    public SingYoYeYoQuest singYoYeYoQuest(){
        return new SingYoYeYoQuest();
    }
    @Bean(name = "belle")
    public RescuringBelleQuest rescuringBelleQuest(){
        return new RescuringBelleQuest();
    }*/
}
