package com.javagda24.labiblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int yearWritten;  // year_written

    @Formula(value = "(year(now()) - year_written)")
//    @Formula(value = "(year(now()) - year(year_written))")
    private Integer howOld;

    private int numberOfPages;
    // ile łącznie jest takich książek w bibliotece
    private int numberOfCopies;

    @ManyToOne()
    private PublishingHouse publishingHouse;
}
