package com.demo.book;

import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BookMapper {

    public BookDTO toDTO(Book book) {

        BookDTO dto = new BookDTO();

        dto.setId(book.getId());
        dto.setName(book.getName());
        dto.setDetails(book.getDetails());
        dto.setAuthor(book.getAuthor());
        dto.setPrice(book.getPrice());
        dto.setPublishedDate(book.getPublishedDate());

        if (book.getReviews() != null) {
            dto.setReviews(
                    book.getReviews()
                            .stream()
                            .map(this::toReviewDTO)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }

    public ReviewDTO toReviewDTO(Review review) {

        ReviewDTO dto = new ReviewDTO();

        dto.setId(review.getId());
        dto.setRating(review.getRating());
        dto.setReview(review.getReview());
        dto.setLikes(review.getLikes());
        dto.setDislikes(review.getDislikes());

        return dto;
    }
}