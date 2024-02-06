package com.example.springsecuritymaster.dao;

import com.example.springsecuritymaster.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Integer> {
}
