package com.demo.book.repository;

import com.demo.book.entity.Book;
import com.demo.book.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {

    List<Review> findByBookId(String bookId);
}