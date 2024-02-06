package com.example.bootcrud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "{author.name.empty.error}")
    @NotBlank(message = "Name cannot be blank!")
    @Pattern(regexp = "[a-zA-Z ]*"
            ,message = "Name cannot contain illegal characters.")
    private String name;
    @Past(message = "Date of Birth must be past.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @NotEmpty(message = "PhoneNumber cannot be empty!")
    private String phoneNumber;
    @NotEmpty(message = "Address cannot be empty.")
    private String address;
    @OneToMany(mappedBy = "author")
    private List<Book> books=
            new ArrayList<>();
    public void addBook(Book book){
        book.setAuthor(this);
        this.books.add(book);
    }
}










