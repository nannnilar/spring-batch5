package com.example.samplerestapi.controller;

import com.example.samplerestapi.dao.EmployeeDao;
import com.example.samplerestapi.entity.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeDao employeeDao;
    @GetMapping("/all")
    public List<EmployeeDto> findAll(){
        return employeeDao.findAll()
                .stream()
                .map(e -> new EmployeeDto(e.getId(),e.getFirstName(),e.getLastName(),e.getEmail()))
                .collect(Collectors.toList());
    }
    @PutMapping("/update")
    public ResponseEntity<EmployeeDto> update(@RequestBody EmployeeDto employeeDto){
        var employee = new Employee(
                employeeDto.firstName,
                employeeDto.lastName,
                employeeDto.email
        );
        employee.setId(employeeDto.id);
       return ResponseEntity.ok().body(toDto(employeeDao.saveAndFlush(employee)));
    }
    private EmployeeDto toDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
    @DeleteMapping("/delete/{id}")
    public List<EmployeeDto> deleteEmployee(@PathVariable("id") int employeeId) {
        if (employeeDao.existsById(employeeId)) {
            employeeDao.deleteById(employeeId);
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, employeeId + "Not Found Employee Lists");

        return employeeDao.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());

    }
    record RequestEmployee (@JsonProperty("first_name") String firstName
            ,@JsonProperty("last_name") String lastName,String email){}
    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody RequestEmployee emp){
        Employee employee = employeeDao.save(new Employee(emp.firstName, emp.lastName, emp.email));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        new EmployeeDto(employee.getId(),
                                employee.getFirstName(),
                                employee.getLastName(),
                                employee.getEmail())
                );
    }
    record EmployeeDto (int id,
                        @JsonProperty ("first_name") String firstName,
                        @JsonProperty("last_name") String lastName, String email
    ){}
}
