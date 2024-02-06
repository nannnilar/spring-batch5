package com.example.autoconfigclient;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class EmployeeService {
    private JdbcTemplate jdbcTemplate;

    public EmployeeService(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }
    public void printEmployeeEmails(){
        System.out.println("Printing Employee Emails..");
        jdbcTemplate.queryForList("select email from employee ").forEach(System.out::println);
    }
}
