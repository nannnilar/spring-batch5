package org.example.dao;

import org.example.ds.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentDao extends JpaRepository<Student,Integer>,MyRepoInterface {
    @Query("select s from Student s where s.firstName = ?1 and s.lastName =?2")
    public Optional<Student> getStudentFirstNameAndLastName(String firstName, String lastName);
    Optional<Student> findByFirstNameAndLastName(String firstName,String lastName);
}
