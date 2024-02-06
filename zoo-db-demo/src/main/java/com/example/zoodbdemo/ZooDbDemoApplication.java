package com.example.zoodbdemo;

import com.example.zoodbdemo.service.ZooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZooDbDemoApplication implements CommandLineRunner {

    private final ZooService zooService;

    public ZooDbDemoApplication(ZooService zooService) {
        this.zooService = zooService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ZooDbDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        zooService.createDb();
        JPAUtil.checkData("select * from cage");
        JPAUtil.checkData("select * from animal");
        JPAUtil.checkData("select * from category");
        JPAUtil.checkData("select * from supplier");
        JPAUtil.checkData("select * from food_item");
        JPAUtil.checkData("select * from animal_food_items");
    }
}
