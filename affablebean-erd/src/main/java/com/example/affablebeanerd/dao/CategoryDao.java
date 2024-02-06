package com.example.affablebeanerd.dao;

import com.example.affablebeanerd.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
}
