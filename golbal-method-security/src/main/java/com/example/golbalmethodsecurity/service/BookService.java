package com.example.golbalmethodsecurity.service;

import com.example.golbalmethodsecurity.ds.Employee;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {

    private Map<String , List<String>> books = Map.of(
            "john",List.of("A pale view of hill","A tale of two cities"),
            "mary",List.of("Black Swan","Under the Greenwood Tree")
    );
    private Map<String ,Employee > employees = Map.of(
                "john",new Employee("John William",
                            List.of("Moon Pig","Dark Knight"),
                            List.of("reader","accountant")),

                    "mary",new Employee("Mary Kite",
                            List.of("Blue Lagoon","White Knight"),
                            List.of("writer","coder"))
                    );

    @PreAuthorize("#name == authentication.principal.username")
    public List<String > getBooks(String name){
        return books.get(name);
    }
    @PostAuthorize("returnObject.roles.contains('reader')")
    public Employee getBookDetails(String name){
            return employees.get(name);
    }
}
