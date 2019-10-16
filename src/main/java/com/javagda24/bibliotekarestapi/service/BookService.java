package com.javagda24.bibliotekarestapi.service;


import com.javagda24.bibliotekarestapi.model.Book;
import com.javagda24.bibliotekarestapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book update(Book book) {
        if (book.getId() != null) {
            return bookRepository.save(book);
        }
        throw new EntityNotFoundException("Id not provided.");
    }

    public Optional<Book> getById(Long bookId) {
        return bookRepository.findById(bookId);
    }

    public void insertIntoDatabase(Book book) {

        book.setId(null); // zerowanie id pozwoli na dodanie a nie na zaktualizowanie.
        bookRepository.save(book);
    }

    public void delete(Long bookId) {
        if (bookRepository.existsById(bookId)) {
            bookRepository.deleteById(bookId);
        }
    }
}
