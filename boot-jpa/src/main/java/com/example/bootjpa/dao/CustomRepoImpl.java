package com.example.bootjpa.dao;

import com.example.bootjpa.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomRepoImpl implements CustomRepo{
    @Autowired
    private EntityManager em;
    @Override
    public Student findtStudentCompleteName(String firstName, String lastName) {
        return em.createQuery("select s from Student s where s.firstName =?1 and s.lastName =?2 ",Student.class)
                .setParameter(1,firstName)
                .setParameter(2,lastName)
                .getSingleResult();
    }
}
