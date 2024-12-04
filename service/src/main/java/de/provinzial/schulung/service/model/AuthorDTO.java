package de.provinzial.schulung.service.model;

import java.util.List;

public class AuthorDTO {

	private Long id;
	private String name;
	private List<BookDTO> books;

	// Standard-Konstruktor
	public AuthorDTO() {
	}

	// Konstruktor mit Parametern
	public AuthorDTO(Long id, String name, List<BookDTO> books) {
		this.id = id;
		this.name = name;
		this.books = books;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BookDTO> getBooks() {
		return this.books;
	}

	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}

}