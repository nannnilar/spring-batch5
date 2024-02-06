package com.example.manytoonedemo.service;

import com.example.manytoonedemo.dao.CategoryDao;
import com.example.manytoonedemo.dao.ProductDao;
import com.example.manytoonedemo.entity.Category;
import com.example.manytoonedemo.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    private final CategoryDao categoryDao;
    private final ProductDao productDao;

    public ProductService(CategoryDao categoryDao, ProductDao productDao) {
        this.categoryDao = categoryDao;
        this.productDao = productDao;
    }
    @Transactional
    public void createDb(){
        Category category1 = new Category();
        category1.setCategoryName("Fruit");

        Category category2 = new Category();
        category2.setCategoryName("Meat");

        Category category3 = new Category();
        category3.setCategoryName("Diary");

        Product p1 = new Product("Apple",2000);
        Product p2 = new Product("Orange",1000);

        Product p3 = new Product("Chicken",15000);
        Product p4 = new Product("Fish",10000);

        Product p5 = new Product("Milk",5000);
        Product p6 = new Product("Butter",10000);

        Product p7 = new Product("Men Shirt",30000);
        Product p8 = new Product("Game Controller",50000);

        p1.setCategory(category1);
        p2.setCategory(category1);

        p3.setCategory(category2);
        p4.setCategory(category2);

        p5.setCategory(category3);
        p6.setCategory(category3);

        productDao.save(p1);
        productDao.save(p2);
        productDao.save(p3);
        productDao.save(p4);
        productDao.save(p5);
        productDao.save(p6);
        productDao.save(p7);
        productDao.save(p8);

        categoryDao.save(category1);
        categoryDao.save(category2);
        categoryDao.save(category3);
    }
}
