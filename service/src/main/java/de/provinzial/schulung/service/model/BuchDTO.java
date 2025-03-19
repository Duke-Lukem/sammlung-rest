package de.provinzial.schulung.service.model;

public class BuchDTO {

	private Long id;
	private Double preis;
	private String name;
	private String isbn;
	private Long autorId;

	// Standard-Konstruktor
	public BuchDTO() {
	}

	public BuchDTO(Long id, Double preis, String name, String isbn, Long authorId) {
		super();
		this.id = id;
		this.preis = preis;
		this.name = name;
		this.isbn = isbn;
		this.autorId = authorId;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPreis() {
		return this.preis;
	}

	public void setPreis(Double preis) {
		this.preis = preis;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Long getAutorId() {
		return this.autorId;
	}

	public void setAutorId(Long authorId) {
		this.autorId = authorId;
	}

}