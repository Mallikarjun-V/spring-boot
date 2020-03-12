package com.learn.controller;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.dto.Book;
import com.learn.service.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Book> list() {
        return bookService.list();
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Book> save(@RequestBody Book book) {
        book.setCreatedDateTime(ZonedDateTime.now());
        bookService.save(book);
        return new ResponseEntity<Book>(book, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET, params = { "name" })
    public List<Book> findByName(@RequestParam("name") String name) {
        System.out.println("Finding by name : " + name);
        return bookService.findByName(name);
        
    }
}
