package com.example.transactionbalancedemo.dao;

import com.example.transactionbalancedemo.ds.Account;
import lombok.SneakyThrows;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDao {
    private JdbcTemplate jdbcTemplate;

    public AccountDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }
    @SneakyThrows
    private Account mapToAccount(ResultSet rs,int i){
        return new Account(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("amount")
        );
    }
    public List<Account> listAllAccount(){
        return jdbcTemplate.query("select * from account",
                this::mapToAccount);
    }
    public void transfer(String fromName,String toName,int amount){
        jdbcTemplate.queryForList("select * from amount ");
    }
    public int getBalance(String name){
        return jdbcTemplate.query(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        return con.prepareStatement("select amount from account where name =?");
                    }
                },
                new PreparedStatementSetter() {

                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setString(1, name);
                    }
                },
                new ResultSetExtractor<Integer>() {
                    @Override
                    public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
                        if (rs.next()){
                            return rs.getInt("amount");
                        }else {
                            throw new RuntimeException("Invalid Amount.");
                        }

                    }
                }
        );
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public int withdraw(String name,int amount){
        int currentAmount = getBalance(name);
        if (currentAmount < amount){
            throw new RuntimeException("Insuffient Amount!");
        }
        int updateAmount = currentAmount-amount;
        jdbcTemplate.update("update account set amount =? where name=?",
                new Object[]{updateAmount,name});
        return updateAmount;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public int deposit(String name,int amount){
        int currentAmount = getBalance(name);
        int updatedAmount = currentAmount + amount;
        jdbcTemplate.update("update account set amount =? where name =?",
                new Object[]{updatedAmount,name});
        return updatedAmount;
    }
}
