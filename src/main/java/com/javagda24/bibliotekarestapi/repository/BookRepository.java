package com.javagda24.bibliotekarestapi.repository;


import com.javagda24.bibliotekarestapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
