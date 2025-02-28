package com.capgemini.library.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Book")

public class Book {
	@Id
	@Column(name = "bookId")
	 private int bookId;
	
	@Column(name = "bookName")
	 private String bookName;
	
	@Column(name = "bookPrice")
	 private int bookPrice;
	 
	@ManyToOne
	@JoinColumn(name="author_id")
	 private Author author;
	

}
