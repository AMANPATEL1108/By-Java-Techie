package com.example.spring_swagger.api.service;

import com.example.spring_swagger.api.dao.BookRepository;
import com.example.spring_swagger.api.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public String saveBooke(Book book) {
        repository.save(book);
        return "Book Added With id " + book.getBookId();
    }

    public Book getBook(int bookId){
        Optional<Book> optionalBook = repository.findById(bookId);
        return optionalBook.orElse(null);
    }

    public List<Book> removeBook(int bookId){
        repository.deleteById(bookId);
        return repository.findAll();
    }
}
