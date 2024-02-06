package com.example.defaulthateoasdemo.dao;

import com.example.defaulthateoasdemo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address,Integer> {
}
