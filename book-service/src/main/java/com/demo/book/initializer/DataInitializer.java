package com.demo.book;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    @Bean
    CommandLineRunner loadData(BookRepository repo) {
        return args -> {

            repo.save(Book.builder()
                    .name("Clean Code")
                    .author("Robert C. Martin")
                    .details("Best practices for writing clean code")
                    .price(499.0)
                    .publishedDate(LocalDate.of(2008, 8, 1))
                    .reviews(List.of("Excellent", "Must read"))
                    .build());

            repo.save(Book.builder()
                    .name("Effective Java")
                    .author("Joshua Bloch")
                    .details("Java best practices")
                    .price(599.0)
                    .publishedDate(LocalDate.of(2017, 12, 1))
                    .reviews(List.of("Advanced", "Very useful"))
                    .build());
        };
    }
}