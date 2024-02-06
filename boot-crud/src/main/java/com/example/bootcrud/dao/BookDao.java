package com.example.bootcrud.dao;

import com.example.bootcrud.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book,Integer> {
}
