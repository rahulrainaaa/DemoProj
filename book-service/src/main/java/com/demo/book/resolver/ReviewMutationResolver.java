package com.demo.book.resolver;

import com.demo.book.entity.Review;
import com.demo.book.request.ReviewInput;
import com.demo.book.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ReviewMutationResolver {

    private final ReviewService service;

    @MutationMapping
    public Review addReview(@Argument ReviewInput input) {
        return service.addReview(input);
    }

    @MutationMapping
    public Boolean likeReview(@Argument String reviewId) {
        return service.likeReview(reviewId);
    }

    @MutationMapping
    public Boolean dislikeReview(@Argument String reviewId) {
        return service.dislikeReview(reviewId);
    }
}
