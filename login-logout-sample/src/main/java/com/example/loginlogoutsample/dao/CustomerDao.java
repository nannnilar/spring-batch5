package com.example.loginlogoutsample.dao;

import com.example.loginlogoutsample.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerDao extends JpaRepository<Customer,Integer> {

    Optional<Customer> findByUserName(String userName );
}
