package com.example.inheritancerelationship.dao;

import com.example.inheritancerelationship.entity.InHouseVet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InHouseVetDao extends JpaRepository<InHouseVet,Integer> {
}
