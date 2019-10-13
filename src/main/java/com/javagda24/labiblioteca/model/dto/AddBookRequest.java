package com.javagda24.labiblioteca.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBookRequest {
    private Long phId;

    private String title;
    private int yearWritten;
    private int numberOfPages;
    private int numberOfCopies;
}
