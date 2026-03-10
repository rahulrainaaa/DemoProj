package com.demo.book.resolver;

import com.demo.book.dto.BookDTO;
import com.demo.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookQueryResolver {

    private final BookService service;

    @QueryMapping
    public List<BookDTO> books() {
        return service.getAllBooks();
    }

    @QueryMapping
    public BookDTO bookById(@Argument String id) {
        return service.getBookById(id);
    }
}