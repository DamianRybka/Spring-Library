package com.javagda24.bibliotekarestapi.controller;


import com.javagda24.bibliotekarestapi.model.Book;
import com.javagda24.bibliotekarestapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public List<Book> getAll() {
        return bookService.getAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getByPathVariable(@PathVariable("id") Long bookId) {
        Optional<Book> bookOptional = bookService.getById(bookId);
        if (bookOptional.isPresent()) {
            return ResponseEntity.ok(bookOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("") // inna metoda to i adres url może być taki sam i się nie gryzie
    @ResponseStatus(code = HttpStatus.CREATED) // created to Http kod 201
    public void insertStudent(@RequestBody Book book) {
        bookService.insertIntoDatabase(book);
    }

    @PostMapping("")
    public ResponseEntity<Book> edit(@RequestBody Book book) {
        Book bookResult = bookService.update(book);

        return ResponseEntity.ok(bookResult);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") Long bookId) {
        bookService.delete(bookId);

    }
}
