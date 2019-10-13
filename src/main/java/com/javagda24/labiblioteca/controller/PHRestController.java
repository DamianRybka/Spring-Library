package com.javagda24.labiblioteca.controller;

import com.javagda24.labiblioteca.model.Book;
import com.javagda24.labiblioteca.model.PublishingHouse;
import com.javagda24.labiblioteca.model.dto.AddBookRequest;
import com.javagda24.labiblioteca.service.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ph")
public class PHRestController {
    @Autowired
    private PublishingHouseService publishingHouseService;

    @PutMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public void putBook(@RequestBody AddBookRequest request){
        publishingHouseService.addBook(request);
    }

    @GetMapping("/list")
    public List<PublishingHouse> list(){
        return publishingHouseService.getAll();
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(PublishingHouse ph){
        publishingHouseService.save(ph);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void save(PublishingHouse ph){
        publishingHouseService.save(ph);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") Long id){
        publishingHouseService.deleteById(id);
    }
}
