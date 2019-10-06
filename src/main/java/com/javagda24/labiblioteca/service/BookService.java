package com.javagda24.labiblioteca.service;

import com.javagda24.labiblioteca.model.Book;
import com.javagda24.labiblioteca.model.PublishingHouse;
import com.javagda24.labiblioteca.repository.BookRepository;
import com.javagda24.labiblioteca.repository.PublishingHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublishingHouseRepository publishingHouseRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public void save(Book book, Long publishingHouseId) {
        if (publishingHouseRepository.existsById(publishingHouseId)) {
            PublishingHouse publishingHouse = publishingHouseRepository.getOne(publishingHouseId);

            book.setPublishingHouse(publishingHouse);

            bookRepository.save(book);
        } else {
            throw new EntityNotFoundException("Publishing house does not exist");
        }
    }

    public Optional<Book> getById(Long id) {
        return bookRepository.findById(id);
    }
}
