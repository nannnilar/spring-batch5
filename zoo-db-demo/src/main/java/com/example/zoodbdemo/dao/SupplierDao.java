package com.example.zoodbdemo.dao;

import com.example.zoodbdemo.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierDao extends JpaRepository<Supplier,Integer> {
}
