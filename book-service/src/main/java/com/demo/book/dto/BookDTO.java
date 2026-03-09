package com.demo.book;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class BookDTO {

    private String id;
    private String name;
    private String details;
    private String author;
    private Double price;
    private LocalDate publishedDate;

    private List<ReviewDTO> reviews;
}