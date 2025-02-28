package com.capgemini.library.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.*;

@Entity
@Data
@Table(name ="Author")
public class Author {
	
	
	@Id
	@Column(name ="AuthorId")
	private int authorId;
	
	@Column(name ="AuthorName")
	private String authorName;
	
	@Column(name ="Description")
	private String description;
    
	@OneToMany(mappedBy="bookId",cascade = CascadeType.ALL)
	private List<Book>book;
}
