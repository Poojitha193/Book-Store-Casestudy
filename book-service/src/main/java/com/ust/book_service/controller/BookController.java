package com.ust.book_service.controller;

import com.ust.book_service.dto.BookDto;
import com.ust.book_service.model.Book;
import com.ust.book_service.service.BookService;
import com.ust.book_service.service.BookServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService){
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody BookDto bookdto){
        Book createdBook = new Book(
                bookdto.bookTitle(),
                bookdto.author(),
                bookdto.price(),
                bookdto.stock()
        );

        bookService.createBook(createdBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @GetMapping
    public ResponseEntity<Book> getAllBooks(){
        return ResponseEntity.status(HttpStatus.FOUND).body((Book) bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.FOUND).body((Book) bookService.getBookById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@Valid @PathVariable long id, @RequestBody BookDto bookdto){
        Book updatedBook = bookService.updateBook(bookdto,id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedBook);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id){
        bookService.deleteBookById(id);
    }
}
