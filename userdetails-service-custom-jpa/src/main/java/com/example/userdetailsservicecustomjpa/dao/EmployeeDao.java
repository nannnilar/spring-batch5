package com.example.userdetailsservicecustomjpa.dao;

import com.example.userdetailsservicecustomjpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
//@EnableJpaRepositories
public interface EmployeeDao extends JpaRepository<Employee,Integer> {
    @Query("""
    select e from Employee e where e.username = :name
""")
    Optional<Employee> findByUserName(@Param("name") String username);

}
