package org.example.service;

import lombok.SneakyThrows;
import org.example.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeService {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public EmployeeService(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }
    public int findEmployeeIdByEmail(String email){
        return jdbcTemplate.query(new PreparedStatementCreator() {
                                      @Override
                                      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                          return con.prepareStatement("select id from employee where email =?");
                                      }
                                  },
                new PreparedStatementSetter() {

                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setString(1, email);
                    }
                },
                new ResultSetExtractor<Integer>() {
                    @Override
                    public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
                        if (rs.next())
                            return rs.getInt("id");
                        else
                            throw new RuntimeException("Not Found!");

                    }
                });
    }
    public double averageResultSetExtractor(){
        return jdbcTemplate.query("select salary from employee",
                new AverageResultSetExtractor());
    }
    public class AverageResultSetExtractor implements ResultSetExtractor<Double>{
        @Override
        public Double extractData(ResultSet rs) throws SQLException, DataAccessException {
            int count = 0;
            double sum = 0;
            while (rs.next()){
                sum += rs.getDouble("salary");
                count++;
            }
            return sum / count;
        }
    }
    public double avarageByRowCallbackHandler(){
        AverageRowCallBackHandler averageRowCallBackHandler =
                new AverageRowCallBackHandler();
        jdbcTemplate.query("select salary from employee",
                averageRowCallBackHandler);
        return averageRowCallBackHandler.averageSalary();
    }
    private class AverageRowCallBackHandler implements RowCallbackHandler{
        private int count;
        private double sum;
        @Override
        public void processRow(ResultSet rs) throws SQLException {
            sum+= rs.getDouble("salary");
            count++;
        }
        public double averageSalary(){
            return sum/count;
        }
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
    public List<Employee> findAllEmployee(){
        return jdbcTemplate.query("select * from employee",
//                this::mapToEmployee);
                (a,b) -> mapToEmployee(a,b));
    };

    public List<String> listEmials(){
        return jdbcTemplate.queryForList("select email from employee",String.class);
    }
}
