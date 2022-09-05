package com.lrm.web;

import com.lrm.domain.Book;
import com.lrm.dto.BookDTO;
import com.lrm.exception.BookNotFoundException;
import com.lrm.exception.InvalidRequestException;
import com.lrm.service.BookService;
import com.lrm.util.CustomerBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookApi {

    private BookService bookService;

    public BookApi(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<?> listAllBooks() {
        List<Book> books = bookService.findAllBooks();
        if(books.isEmpty()){
            throw new BookNotFoundException("書單列表不存在");
        }
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBook(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if(book == null){
            throw new BookNotFoundException(String.format("book by id %s not found", id));
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<?> saveBook(@Valid @RequestBody BookDTO bookDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new InvalidRequestException("Ivliad parameter", bindingResult);
        }
        Book book1 = bookService.saveBook(bookDTO.convertToBook());
        return new ResponseEntity<Book>(book1, HttpStatus.CREATED);
    }

    /**
     * 更新一筆資料，request不用再特別多傳一個ID過去由URL的ID就可以更新
     *
     * @param id
     * @param bookDTO
     * @return
     */
    @PutMapping("/books/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id,@Valid @RequestBody BookDTO bookDTO,BindingResult bindingResult) {
        Book currentBook = bookService.getBookById(id);
        if(currentBook == null){
            throw new BookNotFoundException(String.format("book by id %s not found", id));
        }
        if(bindingResult.hasErrors()){
            throw new InvalidRequestException("Ivliad parameter", bindingResult);
        }
        //BeanUtils.copyProperties(bookDTO,currentBook);
//        convert(bookDTO, currentBook);
        bookDTO.convertToBook(currentBook);
        Book book1 = bookService.updateBook(currentBook);
        return new ResponseEntity<Object>(book1, HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/books")
    public ResponseEntity<?> deleteAllBooks() {
        bookService.deleteAllBook();
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
}
