package de.provinzial.schulung.service.model;

public class BuchDTO {

	private Long id;
	private Double preis;
	private String name;
	private Long autorId;

	// Standard-Konstruktor
	public BuchDTO() {
	}

	/**
	 * @param id
	 * @param preis
	 * @param name
	 * @param authorId
	 */
	public BuchDTO(Long id, Double preis, String name, Long authorId) {
		super();
		this.id = id;
		this.preis = preis;
		this.name = name;
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

	public Long getAutorId() {
		return this.autorId;
	}

	public void setAutorId(Long authorId) {
		this.autorId = authorId;
	}

}