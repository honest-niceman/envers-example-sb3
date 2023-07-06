package com.jpabuddy.enversexamplesb3.controller;

import com.jpabuddy.enversexamplesb3.entity.Book;
import com.jpabuddy.enversexamplesb3.envers.AuditEnversInfo;
import com.jpabuddy.enversexamplesb3.repository.BookRevisionRepository;
import org.springframework.data.history.Revision;
import org.springframework.data.history.RevisionMetadata;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books-history")
public class BookHistoryController {

    private final BookRevisionRepository bookRevisionRepository;

    public BookHistoryController(BookRevisionRepository bookRevisionRepository) {
        this.bookRevisionRepository = bookRevisionRepository;
    }

    @GetMapping("/revisions/{id}")
    public List<Book> getBookRevisions(@PathVariable Long id) {
        return bookRevisionRepository
                .findRevisions(id)
                .stream()
                .map(Revision::getEntity)
                .toList();
    }

    @GetMapping("/creator/{id}")
    public String getCreatorUsername(@PathVariable Long id) {
        Revision<Integer, Book> revision = bookRevisionRepository.findRevision(id, 1).orElseThrow();
        RevisionMetadata<Integer> metadata = revision.getMetadata();
        AuditEnversInfo auditEnversInfo = metadata.getDelegate();
        return auditEnversInfo.getUsername();
    }
}
