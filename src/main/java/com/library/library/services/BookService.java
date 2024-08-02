package com.library.library.services;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.library.library.models.Book;
import com.library.library.repositories.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    //Averiguar porque no necesita ponerle el Autowired
    //@Autowired
    public  BookService(BookRepository bookRepository){
        this.bookRepository =  bookRepository;
    }

    public ResponseEntity<Object> addBook(Book book){
        bookRepository.save(book); //método save delete etc ya viene en spring
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }
    
}
