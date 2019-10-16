package com.javagda24.bibliotekarestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublishingHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "publishingHouse")
    private Set<Book> books;

}