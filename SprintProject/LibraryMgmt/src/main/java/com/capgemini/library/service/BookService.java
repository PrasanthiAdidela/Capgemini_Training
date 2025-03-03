package com.capgemini.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.library.entities.Book;

public interface BookService {

	void addNewBook(Book book);

	List<Book> getAllBooks();

}
