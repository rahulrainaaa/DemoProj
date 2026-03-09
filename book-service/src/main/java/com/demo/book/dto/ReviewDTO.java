package com.demo.book;

import lombok.Data;

@Data
public class ReviewDTO {

    private String id;
    private Integer rating;
    private String review;
    private Integer likes;
    private Integer dislikes;
}