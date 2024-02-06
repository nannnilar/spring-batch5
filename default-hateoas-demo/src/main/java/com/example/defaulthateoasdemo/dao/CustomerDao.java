package com.example.defaulthateoasdemo.dao;

import com.example.defaulthateoasdemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
