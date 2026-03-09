package com.demo.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;

    @Transactional
    public Review addReview(ReviewInput input) {

        Book book = bookRepository.findById(input.getBookId())
                .orElseThrow();

        Review review = Review.builder()
                .rating(input.getRating())
                .review(input.getReview())
                .likes(0)
                .dislikes(0)
                .book(book)
                .build();

        return reviewRepository.save(review);
    }
}