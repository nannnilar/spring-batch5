package com.example.manytoonedemo.dao;

import com.example.manytoonedemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer>{
}
