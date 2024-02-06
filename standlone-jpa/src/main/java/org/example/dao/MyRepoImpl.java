package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.ds.Student;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class MyRepoImpl implements MyRepoInterface{
    private EntityManager em;

    public MyRepoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Student findStudentByFirstNameAndLastName(String firstName, String lastName) {
        return em.createQuery("select s from Student s where s.firstName =?1 and s.lastName=?2",
                Student.class)
                .setParameter(1,firstName)
                .setParameter(2,lastName)
                .getSingleResult();
    }
}
