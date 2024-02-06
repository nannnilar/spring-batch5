package com.example.prepostfilter.service;

import com.example.prepostfilter.ds.Product;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @PreFilter("filterObject.owner == authentication.name")
    public List<Product> findAllProduct(List<Product> products){
        return products;
    }
    @PostFilter("filterObject.owner == authentication.name")
    public List<Product> findAllProductPostFilter(){
        List<Product> products = new ArrayList<>();

        products.add(new Product("john",List.of("Beer","Chocolate")));
        products.add(new Product("mary",List.of("Candy","Pizza")));
        products.add(new Product("thomas",List.of("Pasta","Green Tea")));

        return products;
    }
}
