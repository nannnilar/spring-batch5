package com.example.blogenspringboot.service;

import com.example.blogenspringboot.dao.CategoryDao;
import com.example.blogenspringboot.dao.CustomerDao;
import com.example.blogenspringboot.dao.PostDao;
import com.example.blogenspringboot.entity.Category;
import com.example.blogenspringboot.entity.Customer;
import com.example.blogenspringboot.entity.Post;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogenService {
    private final CategoryDao categoryDao;
    private final CustomerDao customerDao;
    private final PostDao postDao;

    public BlogenService(CategoryDao categoryDao, CustomerDao customerDao, PostDao postDao) {
        this.categoryDao = categoryDao;
        this.customerDao = customerDao;
        this.postDao = postDao;
    }

    public void saveCustomer(Customer customer){
//        System.out.println("==========="+customer);
        customerDao.save(customer);
    }
    public List<Customer> findAllCustomers(){
        return customerDao.findAll();
    }

    public void saveCategory(Category category){
        categoryDao.save(category);
    }
    public List<Category> findAllCategory(){
        return categoryDao.findAll();
    }

    public List<Post> findAllPost(){
        return postDao.findAll();
    }
    public void savePost(Post post){
        Category category = categoryDao.findById((post.getCategory().getId())).orElseThrow(EntityNotFoundException::new);
        Customer customer = customerDao.findById((post.getCustomer().getId())).orElseThrow(EntityNotFoundException::new);
        post.setCategory(category);
        post.setCustomer(customer);
        postDao.save(post);
    }
}
