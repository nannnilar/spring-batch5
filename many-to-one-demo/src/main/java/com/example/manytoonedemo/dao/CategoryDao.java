package com.example.manytoonedemo.dao;

import com.example.manytoonedemo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
}
