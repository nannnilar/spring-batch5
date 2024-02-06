package com.example.affablebeanerd.dao;

import com.example.affablebeanerd.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Integer> {
}
