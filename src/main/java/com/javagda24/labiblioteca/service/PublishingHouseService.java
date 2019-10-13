package com.javagda24.labiblioteca.service;

import com.javagda24.labiblioteca.model.Book;
import com.javagda24.labiblioteca.model.PublishingHouse;
import com.javagda24.labiblioteca.model.dto.AddBookRequest;
import com.javagda24.labiblioteca.repository.BookRepository;
import com.javagda24.labiblioteca.repository.PublishingHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PublishingHouseService {
    @Autowired
    private PublishingHouseRepository publishingHouseRepository;
    @Autowired
    private BookRepository bookRepository;

    public List<PublishingHouse> getAll() {
        return publishingHouseRepository.findAll();
    }

    public void deleteById(Long id) {
        if (publishingHouseRepository.existsById(id)) {
            publishingHouseRepository.deleteById(id);
        }
    }

    public void save(PublishingHouse publishingHouse) {
        publishingHouseRepository.save(publishingHouse);
    }

    public Optional<PublishingHouse> getById(Long id) {
        return publishingHouseRepository.findById(id);
    }


//    ############################################ REST

    public void addBook(AddBookRequest request) {
        if (!publishingHouseRepository.existsById(request.getPhId())) {
            throw new EntityNotFoundException("Publishing house ");
        }

        Book book = mapDtoToBook(request);
        book.setPublishingHouse(publishingHouseRepository.getOne(request.getPhId()));

        bookRepository.save(book);
    }

    public Book mapDtoToBook(AddBookRequest dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setYearWritten(dto.getYearWritten());
        book.setNumberOfCopies(dto.getNumberOfCopies());
        book.setNumberOfPages(dto.getNumberOfPages());

        return book;
    }
}
