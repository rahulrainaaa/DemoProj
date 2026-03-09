package com.demo.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;
    private final BookMapper mapper;

    @Transactional(readOnly = true)
    public List<BookDTO> getAllBooks() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public BookDTO getBookById(String id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Transactional
    public BookDTO save(Book book) {
        repository.save(book);
        book.setDetails("details modified inside Transactional boundary...");
        return mapper.toDTO(book);
    }
}