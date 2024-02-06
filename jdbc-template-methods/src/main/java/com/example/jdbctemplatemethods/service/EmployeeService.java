package com.example.jdbctemplatemethods.service;

import com.example.jdbctemplatemethods.ds.Employee;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

@Service
public class EmployeeService {
    private JdbcTemplate jdbcTemplate;
    public EmployeeService(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public List<Employee> findAllEmployees(){
        return jdbcTemplate.query("select * from employee",
                this::mapToEmployee);
    }
    public void deleteEmployeeById(int id){
        jdbcTemplate.update("delete from employee where id =?",
                id);
    }
    public Employee findEmployeeById(int id){
        return jdbcTemplate.queryForObject("select * from employee where id=?",
                new Object[]{id},
                this::mapToEmployee);
    }
    public void changeEmployeeFirstName(String updateName,int id){
        jdbcTemplate.update("update employee set first_name = ? where id = ?",
                new Object[]{updateName, id});
    }
    public void createNewEmployee(int id, String firstName, String lastName, String email,
                                  Date startDate,double salary){
        jdbcTemplate.update("""
                insert into employee(id,first_name,last_name,email,start_date,salary)
                 values (?,?,?,?,?,?)""",
                id,firstName,lastName,email,startDate,salary);
    }
    public Employee findEmployeeByHighSalary(){
        return jdbcTemplate.queryForObject("select * from employee order by salary desc limit 1",
                this::mapToEmployee);
    }
    @SneakyThrows
    private Employee mapToEmployee(ResultSet rs, int i){
        return new Employee(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getDate("start_date"),
                rs.getDouble("salary")
        );
    }
}
