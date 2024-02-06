package com.example.jpa_onetoone.dao;

import com.example.jpa_onetoone.ds.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address,Integer> {
}
