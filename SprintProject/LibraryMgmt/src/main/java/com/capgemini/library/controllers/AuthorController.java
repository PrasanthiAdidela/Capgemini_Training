package com.capgemini.library.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.library.entities.Author;
import com.capgemini.library.service.AuthorService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/api")
public class AuthorController {
	
	private AuthorService authorService;
	
	@PostMapping(path="/newAuthor")
	public ResponseEntity<?> addAuthor(@RequestBody Author author){
		authorService.createAuthor(author);
		return new ResponseEntity<String>("Author added successfully",HttpStatus.CREATED);
	}

}
