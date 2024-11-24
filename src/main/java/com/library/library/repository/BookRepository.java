package com.library.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.library.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {}
