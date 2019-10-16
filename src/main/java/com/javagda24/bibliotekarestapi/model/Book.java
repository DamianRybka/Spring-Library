package com.javagda24.bibliotekarestapi.model;

import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private int yearWritten;

    @Formula(value = "(year(now())- year_written)")
    private Integer howOld; // wrapper da możliwość nulla bo obiekt gdy coś nie tak pójdzie przy wyliczeniu

    private int numberOfPages;

    private int numberOfCopies;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private PublishingHouse publishingHouse;
}