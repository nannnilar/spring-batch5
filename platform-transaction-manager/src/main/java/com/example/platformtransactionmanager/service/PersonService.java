package com.example.platformtransactionmanager.service;

import com.example.platformtransactionmanager.dao.PersonDaoJdbc;
import com.example.platformtransactionmanager.dao.PersonDaoJpa;
import com.example.platformtransactionmanager.ds.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;
@Service @Transactional
public class PersonService {
    private PersonDaoJdbc personDaoJdbc;
    private PersonDaoJpa personDaoJpa;
    private DataSource dataSource;

    public PersonService(PersonDaoJdbc personDaoJdbc, PersonDaoJpa personDaoJpa, DataSource dataSource) {
        this.personDaoJdbc = personDaoJdbc;
        this.personDaoJpa = personDaoJpa;
        this.dataSource = dataSource;
    }
    public void deleteAll(){
        personDaoJpa.deleteAll();
    }
    public List<Person> findAllPersons(){
        return personDaoJpa.findAll();
    }

    public void createPerson() throws Exception{
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        personDaoJdbc.createPerson("John","Doe","john@gmail.com");
        personDaoJdbc.createPerson("Thomas","Hardy","thomas@gmial.com");
//        System.out.println(3/0);
        personDaoJpa.save(new Person("Thu Thu","Thaw","thuthu@gmail.com"));
        personDaoJpa.save(new Person("Thaw Thaw","Htun Zin","thaw@gmail.com"));
        connection.commit();
//        throw new RuntimeException();
    }
}
