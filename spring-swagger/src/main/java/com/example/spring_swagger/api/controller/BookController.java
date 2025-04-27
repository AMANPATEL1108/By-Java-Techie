package com.example.spring_swagger.api.controller;

import com.example.spring_swagger.api.model.Book;
import com.example.spring_swagger.api.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@Api(value = "Book Service", description = "My Book Store")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping("/save")
    @ApiOperation(value = "store book api")
    public String saveBook(@RequestBody Book book) {
        return service.saveBooke(book);
    }

    @ApiOperation(value = "search book api")
    @GetMapping("/searchbook/{bookId}")
    public Book getBook(@PathVariable int bookId) {
        return service.getBook(bookId);
    }

    @ApiOperation(value = "delete book api")
    @DeleteMapping("/deletbook/{bookId}")
    public List<Book> deleteBook(@PathVariable int bookId) {
        return service.removeBook(bookId);
    }
}
