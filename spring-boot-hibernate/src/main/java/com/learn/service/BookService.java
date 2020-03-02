package com.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.dao.BookRepository;
import com.learn.dto.Book;

@Service
public class BookService {
    
    @Autowired
    BookRepository bookRepository;
    
    public List<Book> list() {
        return bookRepository.findAll();
    }
    
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findByName(String name) {
        return bookRepository.findByName(name);
    }
}
