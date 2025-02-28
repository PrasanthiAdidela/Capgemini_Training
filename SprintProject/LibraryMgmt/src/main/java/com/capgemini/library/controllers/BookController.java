package com.capgemini.library.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.library.entities.Book;
import com.capgemini.library.service.BookService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/api")
public class BookController {
	
	private BookService bookService;
	
	@PostMapping(path="/newBook")
	public ResponseEntity<?> addBook(@RequestBody Book book){
		bookService.addNewBook(book);
		return new ResponseEntity<String>("Added Successfully",HttpStatus.CREATED);
	}
	
	@GetMapping(path="/allBooks")
	public ResponseEntity<?> allBooks(){
		List<Book> allBooks=bookService.getAllBooks();
		return new ResponseEntity<List<Book>>(allBooks,HttpStatus.OK);
	}

}
