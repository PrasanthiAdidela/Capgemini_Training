package com.capgemini.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.library.entities.Book;
import com.capgemini.library.repository.BookRepository;
import com.capgemini.library.service.BookService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService{

	private BookRepository bookRepo;
	
	@Override
	public void addNewBook(Book book) {
		bookRepo.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> allBooks=bookRepo.findAll();
		return allBooks;
	}

}
