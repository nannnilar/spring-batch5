package com.example.prepostfilter.controller;

import com.example.prepostfilter.ds.Product;
import com.example.prepostfilter.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> sellProduct(){
        List<Product> products = new ArrayList<>();

        products.add(new Product("john",List.of("Beer","Chocolate")));
        products.add(new Product("mary",List.of("Candy","Pizza")));
        products.add(new Product("thomas",List.of("Pasta","Green Tea")));

        return productService.findAllProduct(products);
    }
    @GetMapping("/post/products")
    public List<Product> sellProductV2(){
        return productService.findAllProductPostFilter();
    }
}
