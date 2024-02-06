package com.example.affablebeancurd.dao;

import com.example.affablebeancurd.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
}
