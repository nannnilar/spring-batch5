package com.example.blogenspringboot.dao;

import com.example.blogenspringboot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Integer> {
}
