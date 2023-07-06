package com.jpabuddy.enversexamplesb3.controller;

import com.jpabuddy.enversexamplesb3.entity.Book;
import com.jpabuddy.enversexamplesb3.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        if (book.getId() != null) {
            throw new IllegalArgumentException("The ID will be set by the database!");
        }
        return bookRepository.save(book);
    }

    @PatchMapping
    public Book modifyBook(@RequestBody Book request) {
        if (request.getId() == null) {
            throw new IllegalArgumentException("The ID value must be set!");
        }
        Book book = bookRepository.findById(request.getId()).orElseThrow();
        if (request.getTitle() != null) book.setTitle(request.getTitle());
        if (request.getAuthor() != null) book.setAuthor(request.getTitle());
        return bookRepository.save(book);
    }
}
