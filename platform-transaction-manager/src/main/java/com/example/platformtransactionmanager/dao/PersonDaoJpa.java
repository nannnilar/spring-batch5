package com.example.platformtransactionmanager.dao;

import com.example.platformtransactionmanager.ds.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDaoJpa extends JpaRepository<Person,Integer> {
}
