package com.example.manytoonedemo.service;

import com.example.manytoonedemo.dao.CategoryDao;
import com.example.manytoonedemo.dao.ProductDao;
import com.example.manytoonedemo.entity.Category;
import com.example.manytoonedemo.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    private final CategoryDao categoryDao;
    private final ProductDao productDao;

    public ProductService(CategoryDao categoryDao, ProductDao productDao) {
        this.categoryDao = categoryDao;
        this.productDao = productDao;
    }
    @Transactional
    public void addNewProduct(){
        Category category = categoryDao.fetchCategoryProductName("Fruit");
        Product product = new Product("Mango",700);
//        Product managedProduct = productDao.saveAndFlush(product);
        category.addProduct(product);
        categoryDao.save(category);
    }
    @Transactional
    public void removeLastProduct(){
        Category category = categoryDao.fetchCategoryProductName("Fruit");
        List<Product> products = category.getProducts();
        category.removeProduct(products.get(products.size()-1));
    }
    @Transactional
    public void removeFirstProduct(){
        Category category = categoryDao.fetchCategoryProductName("Fruit");
        List<Product> products = category.getProducts();
        category.removeProduct(products.get(0));
    }
    @Transactional
    public void createDb(){
        Category category1 = new Category();
        category1.setCategoryName("Fruit");

        Product product1 = new Product("Apple",3000);
        Product product2 = new Product("Orange",1000);

        category1.addProduct(product1);
        category1.addProduct(product2);
        categoryDao.save(category1);

        /*Category category2 = new Category();
        category2.setCategoryName("Meat");

        Category category3 = new Category();
        category3.setCategoryName("Diary");

        Product p1 = new Product("Apple",2000);
        Product p2 = new Product("Orange",1000);

        Product p3 = new Product("Chicken",15000);
        Product p4 = new Product("Fish",10000);

        Product p5 = new Product("Milk",5000);
        Product p6 = new Product("Butter",10000);*/

       /* Product p7 = new Product("Men Shirt",30000);
        Product p8 = new Product("Game Controller",50000);*/

        /*category1.addProduct(p1);
        category1.addProduct(p2);

        category2.addProduct(p3);
        category2.addProduct(p4);

        category3.addProduct(p5);
        category3.addProduct(p6);


        categoryDao.save(category1);
        categoryDao.save(category2);
        categoryDao.save(category3);*/
    }
}
