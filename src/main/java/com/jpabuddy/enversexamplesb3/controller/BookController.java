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

    @PatchMapping("/{id}/{newTitle}")
    public Book modifyBook(@PathVariable Long id, @PathVariable String newTitle) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setTitle(newTitle);
        return bookRepository.save(book);
    }
}
