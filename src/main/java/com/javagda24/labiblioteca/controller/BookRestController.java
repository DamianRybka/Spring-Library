package com.javagda24.labiblioteca.controller;

import com.javagda24.labiblioteca.model.Book;
import com.javagda24.labiblioteca.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookRestController {
    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public List<Book> list(){
        return bookService.getAll();
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(Book book){
        bookService.save(book);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void save(Book book){
        bookService.save(book);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") Long id){
        bookService.delete(id);
    }


}
