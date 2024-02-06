package com.example.manytoonedemo.dao;

import com.example.manytoonedemo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryDao extends JpaRepository<Category,Integer> {

    @Query("""
select c from Category c join fetch c.products where c.categoryName =?1
""")
    Category fetchCategoryProductName(String name);
}
