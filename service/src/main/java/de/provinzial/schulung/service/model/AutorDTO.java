package de.provinzial.schulung.service.model;

public class AutorDTO {

	private Long id;
	private String name;

	// Standard-Konstruktor
	public AutorDTO() {
	}

	// Konstruktor mit Parametern
	public AutorDTO(Long id, String name) {
		this.id = id;
		this.name = name;
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

}