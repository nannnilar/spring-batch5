package com.example.jpa_onetoone.dao;

import com.example.jpa_onetoone.ds.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Integer> {
}
