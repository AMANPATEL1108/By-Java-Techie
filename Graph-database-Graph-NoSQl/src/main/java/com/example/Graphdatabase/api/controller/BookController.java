package com.example.Graphdatabase.api.controller;

import java.util.List;

import com.example.Graphdatabase.api.node.Book;
import com.example.Graphdatabase.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	private BookRepository repository;

	@PostMapping("/addBook")
	public String addBook(@RequestBody Book book) {
		repository.save(book);
		return "Book Added";
	}

	@GetMapping("/getBooks")
	public List<Book> getBooks() {
		return (List<Book>) repository.findAll();
	}

	@GetMapping("/getBook/{name}")
	public Book getBook(@PathVariable String name) {
		return repository.findByName(name);
	}

	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable String id) {
		repository.deleteById(id);
		return "Book deleted with id : " + id;
	}

}
