package com.ust.book_service.service;

import com.ust.book_service.dto.BookDto;
import com.ust.book_service.exceptions.BookNotFoundException;
import com.ust.book_service.exceptions.DuplicateBookException;
import com.ust.book_service.model.Book;
import com.ust.book_service.repository.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    private BookRepo bookRepo;

    public BookServiceImpl(BookRepo bookRepo){
        this.bookRepo = bookRepo;
    }

    @Override
    public List<Book> getAllBooks() throws BookNotFoundException{
        return bookRepo.findAll();
    }

    @Override
    public Book getBookById(long id) throws BookNotFoundException {
        return bookRepo.findById(id).orElseThrow(()-> new BookNotFoundException("Book not Found"));
    }

    @Override
    public Book createBook(Book book) throws DuplicateBookException {
        return bookRepo.save(book);
    }

    @Override
    public Book updateBook(BookDto dto, long id) throws BookNotFoundException{
        Optional<Book> bookOptional = bookRepo.findById(id);
        if(bookOptional.isPresent()){
            Book book = bookOptional.get();
            book.setAuthor(dto.author());
            book.setTitle(dto.bookTitle());
            book.setPrice(dto.price());
            book.setStock(dto.stock());
            bookRepo.saveAndFlush(book);
            return book;
        }
        else throw new BookNotFoundException("Book with id: "+ id + "is not found!");
    }

    @Override
    public void deleteBookById(long id) throws BookNotFoundException{
        Book deletedBook = bookRepo.findById(id).orElseThrow(()-> new BookNotFoundException("Book not Found"));
        bookRepo.delete(deletedBook);
    }
}
