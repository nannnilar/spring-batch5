package com.example.platformtransactionmanager.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
@Repository
public class PersonDaoJdbc {
    private JdbcTemplate jdbcTemplate;
    public PersonDaoJdbc(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }
    public void createPerson(String firstName,String lastname,String email){
        jdbcTemplate.update("""
        insert into person(first_name,last_name,email)
        values (?,?,?)""" ,
                firstName,lastname,email );
    }
}
