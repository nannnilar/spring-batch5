package com.example.springmvcrestcontroller.dao;

import com.example.springmvcrestcontroller.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person,Integer> {
}
