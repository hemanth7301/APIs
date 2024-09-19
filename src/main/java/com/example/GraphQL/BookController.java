package com.example.GraphQL;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    public List<Book> getBooks() {
        return bookService.findAllBooks();
    }

    @QueryMapping
    public Book bookById(@Argument Long id) {
        return bookService.getBookById(id);
    }

    @MutationMapping
    public Book addBook(@Argument BookInput input) {
        return bookService.addBook(input);
    }

    @MutationMapping
    public Book updateBook(@Argument Long id, @Argument BookInput input) {
        return bookService.updateBook(id, input);
    }

    @MutationMapping
    public Boolean deleteBook(@Argument Long id) {
        return bookService.deleteBook(id);
    }
}
