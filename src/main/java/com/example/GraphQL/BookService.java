package com.example.GraphQL;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BookService {
    private final HashMap<Long, Book> bookRepository = new HashMap<>();
    private long bookID = 1;
    private long authorID=1;

    public List<Book> findAllBooks() {
        return List.copyOf(bookRepository.values());
    }

    public Book getBookById(Long id) {
        return bookRepository.get(id);
    }

    public Book addBook(BookInput bookInput) {
        Book book = new Book();
        book.setId(bookID++);
        book.setName(bookInput.getName());
        book.setPageCount(bookInput.getPageCount());
        Author author = new Author();
        author.setId(authorID++);
        author.setFirstname(bookInput.getAuthor().getFirstname());
        author.setLastname(bookInput.getAuthor().getLastname());
        book.setAuthor(author);
        bookRepository.put(book.getId(), book);
        return book;
    }

    public Book updateBook(Long id,BookInput bookInput ) {
        Book book = bookRepository.get(id);
        if(book!=null){
            book.setName(bookInput.getName());
            book.setPageCount(bookInput.getPageCount());
            Author author = book.getAuthor();
            if(author!=null){
                author.setFirstname(bookInput.getAuthor().getFirstname());
                author.setLastname(bookInput.getAuthor().getLastname());
            }
            book.setAuthor(author);
            book.setAuthor(author);
        }
        return book;
    }

    public Boolean deleteBook(Long id){
        return bookRepository.remove(id)!=null;
    }
}
