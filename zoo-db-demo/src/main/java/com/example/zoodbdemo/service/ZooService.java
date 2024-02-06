package com.example.zoodbdemo.service;

import com.example.zoodbdemo.dao.CageDao;
import com.example.zoodbdemo.dao.CategoryDao;
import com.example.zoodbdemo.dao.SupplierDao;
import com.example.zoodbdemo.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ZooService {
    private final CategoryDao categoryDao;
    private final CageDao cageDao;
    private final SupplierDao supplierDao;

    public ZooService(CategoryDao categoryDao, CageDao cageDao, SupplierDao supplierDao) {
        this.categoryDao = categoryDao;
        this.cageDao = cageDao;
        this.supplierDao = supplierDao;
    }
    @Transactional
    public void createDb(){
        Cage cage1 = new Cage("S001","South");
        Cage cage2 = new Cage("E001","East");
        Cage cage3 = new Cage("E002","East");
        Cage cage4 = new Cage("E003","East");

        Animal animal1 = new Animal("Tiger",3);
        Animal animal2 = new Animal("Monkey",5);
        Animal animal3 = new Animal("Birds",10);
        Animal animal4 = new Animal("Deer",5);

        Category category = new Category();
        category.setCategoryName("Mammals");

        Supplier supplier = new Supplier("John Doe","555-55-55","79 Park Avenue");

        FoodItem foodItem1 = new FoodItem("Wheat",30);
        FoodItem foodItem2 = new FoodItem("Meat",500);
        FoodItem foodItem3 = new FoodItem("Eggs",20);

        //mapping
        cage1.addAnimal(animal1);
        cage2.addAnimal(animal2);
        cage3.addAnimal(animal3);
        cage4.addAnimal(animal4);

        category.addAnimal(animal1);
        category.addAnimal(animal2);
        category.addAnimal(animal3);
        category.addAnimal(animal4);

        supplier.addFoodItem(foodItem1);
        supplier.addFoodItem(foodItem2);
        supplier.addFoodItem(foodItem3);

        animal1.addFoodItem(foodItem1);
        animal1.addFoodItem(foodItem2);
        animal1.addFoodItem(foodItem3);

        animal2.addFoodItem(foodItem1);
        animal3.addFoodItem(foodItem2);
        animal4.addFoodItem(foodItem1);

        categoryDao.save(category);
        cageDao.save(cage1);
        cageDao.save(cage2);
        cageDao.save(cage3);
        cageDao.save(cage4);

        supplierDao.save(supplier);
    }
}
