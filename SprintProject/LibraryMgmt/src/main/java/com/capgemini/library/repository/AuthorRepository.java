package com.capgemini.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.library.entities.Author;
import com.capgemini.library.entities.Book;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	//List<Book> findAllById(int authorId);

}
