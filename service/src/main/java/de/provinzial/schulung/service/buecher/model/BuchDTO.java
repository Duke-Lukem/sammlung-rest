package de.provinzial.schulung.service.buecher.model;

public class BuchDTO {

	private Long id;
	private Double preis;
	private String name;
	private String isbn;
	private String auflage;
	private String erscheinungsjahr;
	private Long autorId;

	// Standard-Konstruktor
	public BuchDTO() {
	}

	public BuchDTO(Long id, Double preis, String name, String isbn, String auflage, String erscheinungsjahr, Long autorId) {
		super();
		this.id = id;
		this.preis = preis;
		this.name = name;
		this.isbn = isbn;
		this.auflage = auflage;
		this.erscheinungsjahr = erscheinungsjahr;
		this.autorId = autorId;
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

	public String getAuflage() {
		return this.auflage;
	}

	public void setAuflage(String auflage) {
		this.auflage = auflage;
	}

	public String getErscheinungsjahr() {
		return this.erscheinungsjahr;
	}

	public void setErscheinungsjahr(String erscheinungsjahr) {
		this.erscheinungsjahr = erscheinungsjahr;
	}

}