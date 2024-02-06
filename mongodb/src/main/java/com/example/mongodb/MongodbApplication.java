package com.example.mongodb;

import com.example.mongodb.entity.Department;
import com.example.mongodb.entity.Student;
import com.example.mongodb.entity.Subject;
import com.example.mongodb.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class MongodbApplication {
  private final StudentRepository studentRepository;
  @Bean
  public ApplicationRunner runner(){
      return runner -> {
          Student student1 =new Student("John Doe","john@gmail.com");
          student1.setDepartment(new Department("IT","IT1"));
          student1.addSubject(new Subject("Java","Beginner Guide",6,2000));
          student1.addSubject(new Subject("Python","Advanced Guide",3,4000));

          Student student2 =new Student("Thomas Hardy","thomas@gmail.com");
          student2.setDepartment(new Department("Computer Science","CS1"));
          student2.addSubject(new Subject("React","Web Development",3,2000));
          student2.addSubject(new Subject("Angular","UI",3,3000));

      };
  }

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }

}
