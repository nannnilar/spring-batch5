package com.example.springmvcrestcontroller.service;

import com.example.springmvcrestcontroller.dao.PersonDao;
import com.example.springmvcrestcontroller.entity.Person;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {
    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }
    public Person savePerson(Person person){
        return personDao.save(person);
    }
    public List<Person> findAll(){
        return personDao.findAll();
    }
    public Person findPersonById(int id){
       return personDao.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    @Transactional
    public Person personUpdateExplicit(int id,Person person){
        Person existingPerson = findPersonById(id);
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(person.getLastName());
        existingPerson.setEmail(person.getEmail());
        return existingPerson;
    }
    public Person personUpdateImplicit(int id,Person person){
        if (personDao.existsById(id)){
            person.setId(id);
           return personDao.saveAndFlush(person);
        } else
            throw new  EntityNotFoundException(id+ " Not Found!!");
    }
    @Transactional
    public Person changeEmail(int id,String email){
        Person existingPerson =findPersonById(id);
        existingPerson.setEmail(email);
        return existingPerson;
    }
    public void deletePersonById(int id){
        if (personDao.existsById(id)) {
            personDao.deleteById(id);
        }else throw new EntityNotFoundException(id + " Not Found!!");
    }
}
