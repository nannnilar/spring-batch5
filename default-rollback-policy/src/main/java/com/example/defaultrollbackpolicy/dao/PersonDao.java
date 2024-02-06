package com.example.defaultrollbackpolicy.dao;

import com.example.defaultrollbackpolicy.ds.Person;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class PersonDao {
    private JdbcTemplate jdbcTemplate;
    public PersonDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }
    public void createPerson(String firstName,String lastName,String email) throws InterruptedException{
        if (firstName.equals("admin")){
            throw new InterruptedException("FirstName connot be admin");
        }
        jdbcTemplate.update("""
            insert into person(first_name,last_name,email)
            values (?,?,?)""",
            firstName,lastName,email);
    }
    public void removeAllPersons(){
        jdbcTemplate.execute("delete from person");
    }
    public List<Person> findAllPersons(){
        return jdbcTemplate.query("select * from person",
                this::mapToPerson);
    }

    @SneakyThrows
    private Person mapToPerson(ResultSet rs,int i){
        return new Person(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email")
        );
    }
}
