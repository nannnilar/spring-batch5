package com.example.bootcrud.service;

import com.example.bootcrud.dao.AuthorDao;
import com.example.bootcrud.dao.BookDao;
import com.example.bootcrud.entity.Author;
import com.example.bootcrud.entity.Book;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    private final AuthorDao authorDao;
    private final BookDao bookDao;

    public BookService(AuthorDao authorDao, BookDao bookDao) {
        this.authorDao = authorDao;
        this.bookDao = bookDao;
    }
    @Transactional
    public void saveBook(Book book){
        Author author = book.getAuthor();
        author.addBook(book);
        bookDao.save(book);
    }
    public List<Book> findAllBooks(){
        return bookDao.findAll();
    }
    public Author findAuthorById(int id){
        return authorDao.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    public void removeAuthor(int id){
        authorDao.deleteById(id);
    }
    public void saveBook(Author author){
        authorDao.save(author);
    }
    public List<Author> listAuthors(){
        return authorDao.findAll();
    }

    public void updateAuthorV2(Author author){
        authorDao.saveAndFlush(author);
    }
    @Transactional
    public void updateAuthorV1(int id,Author author){
        Author existingAuthor = authorDao.findById(id).orElseThrow(EntityNotFoundException::new);
        existingAuthor.setBooks(author.getBooks());
//        existingAuthor.setId(author.getId());
        existingAuthor.setName(author.getName());
        existingAuthor.setAddress(author.getAddress());
        existingAuthor.setPhoneNumber(author.getPhoneNumber());
        existingAuthor.setDateOfBirth(author.getDateOfBirth());

    }
}
