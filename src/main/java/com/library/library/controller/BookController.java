package com.library.library.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.library.models.Book;
import com.library.library.services.BookService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    
    private final BookService bookService;

    //Averiguar porque no necesita ponerle el Autowired
    //@Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @PostMapping("/")
    public ResponseEntity<Object> addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

}
