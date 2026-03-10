package com.demo.book.resolver;

import com.demo.book.dto.BookDTO;
import com.demo.book.entity.Book;
import com.demo.book.request.BookInput;
import com.demo.book.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class BookMutationResolver {

    private final BookService service;

    @MutationMapping
    public BookDTO createBook(@Valid @Argument BookInput input) {

        Book book = Book.builder()
                .name(input.getName())
                .details(input.getDetails())
                .author(input.getAuthor())
                .price(input.getPrice())
                .publishedDate(LocalDate.parse(input.getPublishedDate()))
                // .reviews(input.getReviews())
                .build();

        return service.save(book);
    }
}