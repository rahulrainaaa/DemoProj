package com.demo.book.initializer;

import com.demo.book.entity.Book;
import com.demo.book.entity.Review;
import com.demo.book.repository.BookRepository;
import com.demo.book.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    @Bean
    CommandLineRunner loadData(BookRepository bookRepository,
                               ReviewRepository reviewRepository) {

        return args -> {

            List<Book> books = List.of(
                    Book.builder()
                            .name("Clean Code")
                            .author("Robert C. Martin")
                            .details("Best practices for writing clean code")
                            .price(499.0)
                            .publishedDate(LocalDate.of(2008, 8, 1))
                            .build(),

                    Book.builder()
                            .name("Effective Java")
                            .author("Joshua Bloch")
                            .details("Java best practices")
                            .price(599.0)
                            .publishedDate(LocalDate.of(2017, 12, 1))
                            .build(),

                    Book.builder()
                            .name("Design Patterns")
                            .author("GoF")
                            .details("Classic design patterns book")
                            .price(699.0)
                            .publishedDate(LocalDate.of(1994, 10, 21))
                            .build(),

                    Book.builder()
                            .name("Refactoring")
                            .author("Martin Fowler")
                            .details("Improving existing code")
                            .price(650.0)
                            .publishedDate(LocalDate.of(1999, 7, 8))
                            .build()
            );

            books = bookRepository.saveAll(books);

            List<Review> reviews = new ArrayList<>();

            for (Book book : books) {

                for (int i = 1; i <= 5; i++) {

                    reviews.add(
                            Review.builder()
                                    .rating((int) (System.currentTimeMillis() % 5) + 1)
                                    .review("Review " + i + " for " + book.getName())
                                    .likes(i * 3)
                                    .dislikes(i)
                                    .book(book)
                                    .build()
                    );
                }
            }

            reviewRepository.saveAll(reviews);
        };
    }
}