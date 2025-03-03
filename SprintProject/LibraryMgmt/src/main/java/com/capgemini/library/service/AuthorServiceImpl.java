package com.capgemini.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capgemini.library.entities.Author;
import com.capgemini.library.entities.Book;
import com.capgemini.library.repository.AuthorRepository;
import com.capgemini.library.repository.BookRepository;
import com.capgemini.library.service.AuthorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
	private BookRepository bookRepo;
	private AuthorRepository authorRepo;
	@Override
	public void createAuthor(Author author) {
	    authorRepo.save(author);
	}

	@Override
	public List<Author> getAllAuthor() {
		List<Author> authors = authorRepo.findAll();
		return authors;
	}

	@Override
	public void deleteAuthor(int authorId) {
		authorRepo.deleteById(authorId);

	}

	@Override
	public void updateAuthor(int authorId,Author newauthor) {
	   Optional<Author>opt = authorRepo.findById(authorId);
	   if(opt.isPresent()) {
		   Author author = opt.get();
		   author.setAuthorName(newauthor.getAuthorName());
		   author.setDescription(newauthor.getDescription());
		   authorRepo.save(author);
		   
		   
	   }
	}

	

//	@Override
//	public List<Book> getAllBooks(int authorId) {
//		Author author=authorRepo.findById(authorId).get();
//		List<Book>list=authorRepo.findAllById(authorId);
//		
//		return list;
//	}

}
