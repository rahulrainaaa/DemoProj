package com.demo.book;

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
}