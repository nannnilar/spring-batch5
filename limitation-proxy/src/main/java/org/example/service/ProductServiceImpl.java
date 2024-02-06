package org.example.service;

import org.example.ds.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService{

    @Override
    public void add(Product product) {
        findProductById(1);
    }

    @Override
    public Product findProductById(int id) {
        return new Product();
    }

    public void doSomething(){

    }
}
