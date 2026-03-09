package com.demo.book;

import lombok.Data;

@Data
public class BookInput {

    private String name;
    private String details;
    private String author;
    private Double price;
    private String publishedDate;
}