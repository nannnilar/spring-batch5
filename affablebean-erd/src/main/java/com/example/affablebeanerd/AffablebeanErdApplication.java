package com.example.affablebeanerd;

import com.example.affablebeanerd.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AffablebeanErdApplication implements CommandLineRunner {
    private final ProductService productService;

    public AffablebeanErdApplication(ProductService productService) {
        this.productService = productService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AffablebeanErdApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productService.createDb();
        JPAUtil.checkData("select * from category");
        JPAUtil.checkData("select * from product");
        JPAUtil.checkData("select * from order_product");
        JPAUtil.checkData("select * from customer_order");
        JPAUtil.checkData("select * from customer");

    }
}
