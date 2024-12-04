package de.provinzial.schulung.service.model;

import java.util.List;

public class AutorDTO {

	private Long id;
	private String name;
	private List<BuchDTO> buecher;

	// Standard-Konstruktor
	public AutorDTO() {
	}

	// Konstruktor mit Parametern
	public AutorDTO(Long id, String name, List<BuchDTO> buecher) {
		this.id = id;
		this.name = name;
		this.buecher = buecher;
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

	public List<BuchDTO> getBuecher() {
		return this.buecher;
	}

	public void setBuecher(List<BuchDTO> buecher) {
		this.buecher = buecher;
	}

}