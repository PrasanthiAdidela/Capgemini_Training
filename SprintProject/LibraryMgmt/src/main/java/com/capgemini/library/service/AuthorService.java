package com.capgemini.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.library.entities.Author;
import com.capgemini.library.entities.Book;


public interface AuthorService {
	
	public void createAuthor(Author author);
	public List<Author>getAllAuthor();
	public void deleteAuthor(int authorId);
	public void updateAuthor(int authorId,Author author);
	//public List<Book>getAllBooks(int authorId);
	//public void addNewAuthor(Author author);

}
