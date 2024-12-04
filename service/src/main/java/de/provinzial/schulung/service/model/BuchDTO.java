package de.provinzial.schulung.service.model;

public class BookDTO {

	private Long id;
	private String title;
	private Long authorId;

	// Standard-Konstruktor
	public BookDTO() {
	}

	// Konstruktor mit Parametern
	public BookDTO(Long id, String title, Long authorId) {
		this.id = id;
		this.title = title;
		this.authorId = authorId;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getAuthorId() {
		return this.authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

}