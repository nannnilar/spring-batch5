package org.example.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.dao.MyRepoDao;
import org.example.dao.StudentDao;
import org.example.ds.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentDao studentDao;
    @Autowired
    private MyRepoDao myRepoDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    public void createStudent(){
        Student s1 = new Student(1,"John","Doe","john@gmail.com");
        Student s2 = new Student(2,"Thomas","Hardy","thomas@gmail.com");
        Student s3 = new Student(3,"Lwin","Lwin Than","lwin@gmail.com");

        studentDao.save(s1);
        studentDao.save(s2);
        studentDao.save(s3);
    }
    /*public  Student findByFirStNameAndLastName(String firstName,String lastName){
        return studentDao.findByFirstNameAndLastName(firstName,lastName).orElseThrow(EntityNotFoundException::new );
    }*/
    public  Student findStudentByFirstNameAndLastName(String firstName,String lastName){
        return studentDao.findByFirstNameAndLastName(firstName,lastName).orElseThrow(EntityNotFoundException::new );
    }
    public Student customRepo(String firstName,String lastName){
        return studentDao.findStudentByFirstNameAndLastName(firstName,lastName);
    }
    /*public Student customRepo(String firstName,String lastName){
        return myRepoDao.findStudentByFirstNameAndLastName(firstName,lastName);
    }*/
    public List<Student> findAll(){
        return studentDao.findAll();
    }

}
