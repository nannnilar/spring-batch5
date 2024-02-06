package com.example.affablebeanerd.service;

import com.example.affablebeanerd.dao.CategoryDao;
import com.example.affablebeanerd.dao.CustomerDao;
import com.example.affablebeanerd.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class ProductService {
    private final CustomerDao customerDao;
    private final CategoryDao categoryDao;

    public ProductService(CustomerDao customerDao, CategoryDao categoryDao) {
        this.customerDao = customerDao;
        this.categoryDao = categoryDao;
    }
    @Transactional
    public void createDb(){
        Category category1 = new Category();
        Category category2 = new Category();
        category1.setName("Fruits");
        category2.setName("Meat");

        Product product1 = new Product("Apple",2000,"Fresh Fruit", LocalDate.now());
        Product product2 = new Product("Orange",2000,"Fresh Fruit", LocalDate.now());
        Product product3 = new Product("Chicken",15000,"Fresh", LocalDate.now());
        Product product4 = new Product("Fish",10000,"Fresh", LocalDate.now());

        Customer customer1 = new Customer("John Doe","john@gmail.com","55-55-555",
                "79 Park Avenue","Yangon","111111");

        CustomerOrder customerOrder1 = new CustomerOrder(50.5,LocalDate.now(),123456);
        CustomerOrder customerOrder2 = new CustomerOrder(100,LocalDate.now(),23456);

        category1.addProduct(product1);
        category1.addProduct(product2);
        category2.addProduct(product3);
        category2.addProduct(product4);

        customer1.addCustomerOrder(customerOrder1);
        customer1.addCustomerOrder(customerOrder2);

        OrderProduct orderProduct1 = new OrderProduct();
        orderProduct1.setQuantity(100);

        product1.addOrderProduct(orderProduct1);
        customerOrder1.addOrderProduct(orderProduct1);

        OrderProduct orderProduct2 = new OrderProduct();
        orderProduct2.setQuantity(50);
        product3.addOrderProduct(orderProduct2);
        customerOrder1.addOrderProduct(orderProduct2);

        customerDao.save(customer1);
        categoryDao.save(category1);
        categoryDao.save(category2);
    }
}
