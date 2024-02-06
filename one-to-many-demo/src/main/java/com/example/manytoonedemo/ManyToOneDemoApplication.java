package com.example.manytoonedemo;

import com.example.manytoonedemo.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManyToOneDemoApplication implements CommandLineRunner {
    private final ProductService productService;

    public ManyToOneDemoApplication(ProductService productService) {
        this.productService = productService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ManyToOneDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productService.createDb();
        System.out.println();
        System.out.println("Add New Product");
        productService.addNewProduct();
        System.out.println();
        System.out.println("Remove From First Product");
        productService.removeFirstProduct();
        System.out.println();
        System.out.println("Remove From Last Product");
        productService.removeLastProduct();

        JPAUtil.checkData("select * from category");
        JPAUtil.checkData("select * from product");
        JPAUtil.checkData("select * from category_products");
    }
}
