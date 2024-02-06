package com.example.mongodb.service;

import com.example.mongodb.dto.StudentDto;
import com.example.mongodb.entity.Student;
import com.example.mongodb.repository.StudentRepository;
import com.example.mongodb.util.EntityToDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentDto saveStudent(StudentDto studentDto){
        return EntityToDto.toDto(this.studentRepository.save(EntityToDto.toEntity(studentDto)));
    }
    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }

    public StudentDto findStudentById(String id){
        return EntityToDto.toDto(studentRepository.findById(id)
                .orElseThrow(RuntimeException::new));
    }
    public StudentDto updateStudent(String id,StudentDto studentDto){
        StudentDto oldStudent = findStudentById(id);
        BeanUtils.copyProperties(studentDto,oldStudent);
        oldStudent.setId(id);

        return saveStudent(oldStudent);
    }
    public void deleteStudentById(String id){
        if (studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Not Found!");
        }
    }
    public List<StudentDto> findAllstudentByName(String name){
        return studentRepository.findByName(name)
                .stream()
                .map(EntityToDto::toDto)
                .collect(Collectors.toList());
    }
}
