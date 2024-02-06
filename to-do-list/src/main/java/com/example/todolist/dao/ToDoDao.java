package com.example.todolist.dao;

import com.example.todolist.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoDao extends JpaRepository<ToDo,Integer> {
}
