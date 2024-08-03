package com.library.library.services;

//import java.util.HashMap;
import java.util.List;
//import java.util.Map;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.library.library.models.Book;
import com.library.library.repositories.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    //Averiguar porque no necesita ponerle el Autowired -> creo que es porque en vez de poner el @Component y se pone directamente el @Service
    //@Autowired
    public  BookService(BookRepository bookRepository){
        this.bookRepository =  bookRepository;
    }

    public ResponseEntity<Object> addBook(Book book){
        bookRepository.save(book); //método save delete etc ya viene en spring
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    //Update sin mensajes, solo enviando el libro editado 
    public ResponseEntity<Object> updateBook(Integer id, Book updatedBook){
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(!bookOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Book existingBook = bookOptional.get();

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setIsbn(updatedBook.getIsbn());
        bookRepository.save(existingBook);
        return ResponseEntity.ok(existingBook);
    }

    //Update con mensaje y enviando el libro editado 
    /* public ResponseEntity<Object> updateBook(Integer id, Book updatedBook){
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(!bookOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Book existingBook = bookOptional.get();

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setIsbn(updatedBook.getIsbn());
        bookRepository.save(existingBook);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Libro editado correctamente");
        response.put("book", existingBook);

        return ResponseEntity.ok(response);
    } */

    //Delete sin mensajes 
    public ResponseEntity<Object> deleteBook(Integer id){
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(!bookOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //Delete con mensajes 
    /* public ResponseEntity<Object> deleteBook(Integer id){
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(!bookOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.ok("Libro eliminado correctamente");
    } */

    public ResponseEntity<Object> getBookById(Integer id){
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(!bookOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Book book = bookOptional.get();
        return ResponseEntity.ok(book);
    }
    
}
