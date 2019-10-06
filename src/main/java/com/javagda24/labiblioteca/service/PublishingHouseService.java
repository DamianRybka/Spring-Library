package com.javagda24.labiblioteca.service;

import com.javagda24.labiblioteca.model.PublishingHouse;
import com.javagda24.labiblioteca.repository.PublishingHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublishingHouseService {
    @Autowired
    private PublishingHouseRepository publishingHouseRepository;

    public List<PublishingHouse> getAll() {
        return publishingHouseRepository.findAll();
    }

    public void deleteById(Long id) {
        publishingHouseRepository.deleteById(id);
    }

    public void save(PublishingHouse publishingHouse) {
        publishingHouseRepository.save(publishingHouse);
    }

    public Optional<PublishingHouse> getById(Long id) {
        return publishingHouseRepository.findById(id);
    }
}
