package com.example.affablebeancurd.service;

import com.example.affablebeancurd.dao.CategoryDao;
import com.example.affablebeancurd.dao.ProductDao;
import com.example.affablebeancurd.entity.Category;
import com.example.affablebeancurd.entity.Product;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final CategoryDao categoryDao;
    private final ProductDao productDao;

    public ProductService(CategoryDao categoryDao, ProductDao productDao) {
        this.categoryDao = categoryDao;
        this.productDao = productDao;
    }
    public void saveCategory(Category category){
        categoryDao.save(category);
    }
    public Category findCategoryById(int id){
        return categoryDao.findById(id).orElseThrow(ExceptionInInitializerError::new);
    }
    public void saveProduct(Product product){
        Category category = findCategoryById(product.getCategory().getId());
        category.addProduct(product);
        productDao.save(product);
    }
    public void  updateProduct(Product product){
        productDao.saveAndFlush(product);
    }
    public Product findProductIById(int id){
        return productDao.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    public void removeProduct(int id){
        productDao.deleteById(id);
    }
    public List<Product> findAllProducts(){
        return productDao.findAll();
    }
    public List<Category> findAllCategory(){
        return categoryDao.findAll();
    }
}

