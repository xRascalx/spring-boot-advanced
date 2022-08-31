package com.lrm.web;

import com.lrm.domain.Book;
import com.lrm.exception.BookNotFoundException;
import com.lrm.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        if(book == null){
            throw new BookNotFoundException("書單訊息不存在");
        }
        model.addAttribute("book", book);
        return "book";
    }
}
