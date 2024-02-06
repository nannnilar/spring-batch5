package com.example.golbalmethodsecurity.controller;

import com.example.golbalmethodsecurity.ds.Employee;
import com.example.golbalmethodsecurity.service.BookService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    private final BookService bookService;

    public HelloController(BookService bookService) {
        this.bookService = bookService;
    }

        @RolesAllowed("ADMIN")
//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/greet")
    public String greet(){
        return "Have a good day Sar!";
    }

    @RolesAllowed("USER")
//    @PreAuthorize("hasAnyRole({'ADMIN','USER'})")
    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }
    @GetMapping("/book/{name}")
    public List<String> showAllBooks(@PathVariable String name){
        return bookService.getBooks(name);
    }
    @GetMapping("/employee/{name}")
    public Employee employeeDetails(@PathVariable String name){
        return bookService.getBookDetails(name);
    }

}
