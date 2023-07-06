package com.jpabuddy.enversexamplesb3.repository;

import com.jpabuddy.enversexamplesb3.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.history.RevisionRepository;

public interface BookRepository extends JpaRepository<Book, Long> { }