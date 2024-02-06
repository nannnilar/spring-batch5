package com.example.connectionjdbctemplate.service;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Service
public class EmployeeService {
    private JdbcTemplate jdbcTemplate;
    public EmployeeService(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }
    public int employeeCount(){
        return jdbcTemplate.queryForObject("select count(id) from employee",
                Integer.class);
    }
    @Transactional
    public void printWithTransaction(){
        System.out.println(employeeCount());
        System.out.println(employeeCount());
        System.out.println(employeeCount());
        System.out.println(employeeCount());
        System.out.println(employeeCount());
    }
    public void printWithoutTransaction(){
        System.out.println(employeeCount());
        System.out.println(employeeCount());
        System.out.println(employeeCount());
        System.out.println(employeeCount());
        System.out.println(employeeCount());
    }
}
