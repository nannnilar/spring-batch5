package com.example.manytomanydemo.service;

import com.example.manytomanydemo.dao.StudentDao;
import com.example.manytomanydemo.dao.SubjectDao;
import com.example.manytomanydemo.entity.Student;
import com.example.manytomanydemo.entity.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    private final StudentDao studentDao;
    private final SubjectDao subjectDao;

    public StudentService(StudentDao studentDao, SubjectDao subjectDao) {
        this.studentDao = studentDao;
        this.subjectDao = subjectDao;
    }
    @Transactional
    public void createDb(){
        Student student1 = new Student("John Doe","ISM");
        Student student2 = new Student("Thomas Hardy","ISY");
        Student student3 = new Student("Charles","PISM");

        Subject subject1 = new Subject("Pthyon",6,300000);
        Subject subject2 = new Subject("Java",6,500000);
        Subject subject3 = new Subject("Groovy",2,200000);

        subject1.addStudent(student1);
        subject2.addStudent(student1);
        subject3.addStudent(student1);

        subject2.addStudent(student2);
        subject2.addStudent(student3);

        /*student1.addSubject(subject1);
        student1.addSubject(subject2);
        student1.addSubject(subject3);

        student2.addSubject(subject2);
        student3.addSubject(subject2);*/

        studentDao.save(student1);
        studentDao.save(student2);
        studentDao.save(student3);
    }
}
