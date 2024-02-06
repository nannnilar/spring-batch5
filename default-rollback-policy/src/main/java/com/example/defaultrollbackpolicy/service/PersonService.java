package com.example.defaultrollbackpolicy.service;

import com.example.defaultrollbackpolicy.dao.PersonDao;
import com.example.defaultrollbackpolicy.ds.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }
    public List<Person> findAllPersons(){
        return personDao.findAllPersons();
    }
    public void removeAll(){
         personDao.removeAllPersons();
    }
    @Transactional(rollbackFor = InterruptedException.class)
    public void create5PersonsWithTransaction()throws InterruptedException {
        personDao.createPerson("John","Doe","johndoe@gmail.com");
        personDao.createPerson("Thomas","Hardy","thomas@gmail.com");
        personDao.createPerson("Thu","Thu","thu@gmail.com");
        personDao.createPerson("admin","Su","su@gmail.com");
        personDao.createPerson("Thuza","New","thuza@gmail.com");

        throw new InterruptedException();
    }
    public void create5PersonsWithoutTransaction()throws InterruptedException{
        personDao.createPerson("John","Doe","johndoe@gmail.com");
        personDao.createPerson("Thomas","Hardy","thomas@gmail.com");
        personDao.createPerson("Thu","Thu","thu@gmail.com");
        personDao.createPerson("admin","Su","su@gmail.com");
        personDao.createPerson("Thuza","New","thuza@gmail.com");

        throw new InterruptedException();

    }
}
