package com.ust.book_service.service;

import com.ust.book_service.dto.BookDto;
import com.ust.book_service.exceptions.BookNotFoundException;
import com.ust.book_service.model.Book;
import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();
    public Book getBookById(long id);
    public Book createBook(Book book);
    public Book updateBook(BookDto bookdto,long id);
    public void deleteBookById(long id);
}
