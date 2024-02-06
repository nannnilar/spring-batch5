package org.example.service;

import org.example.ds.Product;

public interface ProductService {

    void add(Product product);

    Product findProductById(int id);
}
