package com.demo.book.service;

import com.demo.book.entity.Book;
import com.demo.book.entity.Review;
import com.demo.book.repository.BookRepository;
import com.demo.book.repository.ReviewRepository;
import com.demo.book.request.ReviewInput;
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

    //@Transactional
    public boolean likeReview(String reviewId) {
        int rowsUpdated = reviewRepository.incrementLikes(reviewId, 1);
        if (rowsUpdated == 0) {
            throw new RuntimeException("Review not found");
        }
        return true;
    }

    //@Transactional
    public boolean dislikeReview(String reviewId) {
        int rowsUpdated = reviewRepository.incrementDislikes(reviewId, 1);
        if (rowsUpdated == 0) {
            throw new RuntimeException("Review not found");
        }
        return true;
    }
}