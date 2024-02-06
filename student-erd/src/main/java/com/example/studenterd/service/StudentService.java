package com.example.studenterd.service;

import com.example.studenterd.dao.ProvinceDao;
import com.example.studenterd.dao.SubjectDao;
import com.example.studenterd.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    private final ProvinceDao provinceDao;
    private final SubjectDao subjectDao;

    public StudentService(ProvinceDao provinceDao, SubjectDao subjectDao) {
        this.provinceDao = provinceDao;
        this.subjectDao = subjectDao;
    }
    @Transactional
    public void createDb(){
        Student s1 = new Student("Thaw Thaw",22,"ISM", Gender.Female);
        Student s2 = new Student("Thaw Thaw Htun Zin",22,"ISM", Gender.Female);
        Student s3 = new Student("John Doe",22,"ISM", Gender.Male);
        Student s4 = new Student("Thomas Hardy",22,"ISM", Gender.Male);

        Province province1 = new Province();
        Province province2 = new Province();
        province1.setName("Sule");
        province2.setName("Hlaing");

        province1.addStudent(s1);
        province1.addStudent(s3);
        province2.addStudent(s2);
        province2.addStudent(s4);

        Subject subject1 = new Subject("Pthyon",6,1000);
        Subject subject2 = new Subject("Java",6,1000);
        Subject subject3 = new Subject("Spring",6,3000);

        StudentSubject studentSubject1 = new StudentSubject();
        studentSubject1.setMarks(95);
        s1.addStudentSubject(studentSubject1);
        subject2.addStudentSubject(studentSubject1);

        StudentSubject studentSubject2 = new StudentSubject();
        studentSubject2.setMarks(80);
        s1.addStudentSubject(studentSubject2);
        subject1.addStudentSubject(studentSubject2);

        StudentSubject studentSubject3 = new StudentSubject();
        studentSubject3.setMarks(90);
        s2.addStudentSubject(studentSubject3);
        subject2.addStudentSubject(studentSubject3);

        provinceDao.save(province1);
        provinceDao.save(province2);

        subjectDao.save(subject1);
        subjectDao.save(subject2);
        subjectDao.save(subject3);
    }
}
