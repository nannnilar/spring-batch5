package org.example.dao;

import org.example.ds.Student;
import org.springframework.data.repository.CrudRepository;

public interface MyRepoDao extends CrudRepository<Student,Integer>,MyRepoInterface {

}
