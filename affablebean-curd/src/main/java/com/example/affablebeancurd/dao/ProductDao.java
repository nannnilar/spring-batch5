package com.example.affablebeancurd.dao;

import com.example.affablebeancurd.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {
}
