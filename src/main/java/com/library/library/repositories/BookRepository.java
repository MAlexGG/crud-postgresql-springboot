package com.library.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.library.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    
    

}
