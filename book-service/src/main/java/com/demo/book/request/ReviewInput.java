package com.demo.book.request;

import lombok.Data;

@Data
public class ReviewInput {

    private String bookId;
    private Integer rating;
    private String review;
}