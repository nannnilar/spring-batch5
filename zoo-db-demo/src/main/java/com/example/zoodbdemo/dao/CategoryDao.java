package com.example.zoodbdemo.dao;

import com.example.zoodbdemo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
}
