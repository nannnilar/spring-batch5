package com.example.zoodbdemo.dao;

import com.example.zoodbdemo.entity.Cage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CageDao extends JpaRepository<Cage,Integer> {
}
