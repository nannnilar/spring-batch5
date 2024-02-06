package com.example.mongodb.controller;

import com.example.mongodb.dto.StudentDto;
import com.example.mongodb.entity.Student;
import com.example.mongodb.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    @PostMapping("/create")
    public StudentDto createStudent(@RequestBody StudentDto studentDto){
        return studentService.saveStudent(studentDto);
    }
    @GetMapping("/student-list")
    public List<Student> listStudent(){
        return studentService.findAllStudent();
    }
    @GetMapping("/{id}")
    public StudentDto findStudent(@PathVariable String id){
        return studentService.findStudentById(id);
    }
    @PutMapping("/{id}")
    public StudentDto updateStudent(@PathVariable String id,
                                    @RequestBody StudentDto studentDto){
        return studentService.updateStudent(id,studentDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/find/name")
    public List<StudentDto> findAllStudentByName(@RequestParam("name") String name){
       return studentService.findAllstudentByName(name);

    }
}
