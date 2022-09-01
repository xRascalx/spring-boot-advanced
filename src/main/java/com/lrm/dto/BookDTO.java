package com.lrm.dto;

import com.lrm.domain.Book;
import com.lrm.util.CustomerBeanUtils;
import org.springframework.beans.BeanUtils;

public class BookDTO {

    private String author;
    private String description;
    private String name;
    private Integer status;

    public BookDTO() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void convertToBook(Book book){
        new BookConvert().convert(this,book);

    }

    private class BookConvert implements Convert<BookDTO, Book> {

        @Override
        public Book convert(BookDTO bookDTO, Book book) {
            String[] nullPropertyNames = CustomerBeanUtils.getNullPropertyNames(bookDTO);
            BeanUtils.copyProperties(bookDTO, book, nullPropertyNames);
            return book;
        }

        @Override
        public Book convert(BookDTO bookDTO) {
            return null;
        }
    }
}
