package com.jpabuddy.enversexamplesb3.repository;

import com.jpabuddy.enversexamplesb3.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> { }