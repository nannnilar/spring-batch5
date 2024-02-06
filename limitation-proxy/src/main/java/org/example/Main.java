package org.example;

import org.example.ds.Product;
import org.example.service.ProductService;
import org.example.service.ProductServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        ProductServiceImpl productService = context.getBean(ProductServiceImpl.class);
        productService.add(new Product());
        productService.doSomething();
//        productService.findProductById(1);
    }
}