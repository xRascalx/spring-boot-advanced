package com.lrm.service;

import com.lrm.domain.Book;

import java.util.List;

public interface BookService {
    Book getBookById(Long id);

    List<Book> findAllBooks();

    Book saveBook(Book book);

    Book updateBook(Book book);

    void deleteBook(Long id);

    void deleteAllBook();

}
