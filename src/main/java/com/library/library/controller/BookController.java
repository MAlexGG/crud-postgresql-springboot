package com.library.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.library.model.Book;
import com.library.library.service.BookService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    
    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @PostMapping("/")
    public ResponseEntity<Object> addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }
    
    @PutMapping("/{id}")    
    public ResponseEntity<Object> updateBook(@PathVariable Integer id, @RequestBody Book updatedBook){
        return bookService.updateBook(id, updatedBook);
    }

    @DeleteMapping("/{id}")  
    public ResponseEntity<Object> deleteBook(@PathVariable Integer id){
        return bookService.deleteBook(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable Integer id){
        return bookService.getBookById(id);
    }



}
