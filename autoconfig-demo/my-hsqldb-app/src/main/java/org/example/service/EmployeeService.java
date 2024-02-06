package org.example.service;

import org.hsqldb.Database;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class EmployeeService {
    private JdbcTemplate jdbcTemplate;

    public EmployeeService(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }
    public List<String > listEmails(){
        return jdbcTemplate.queryForList("select email from employee", String.class);
    }
}
