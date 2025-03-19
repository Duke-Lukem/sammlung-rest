package de.provinzial.schulung.persistenz;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BuchEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double preis;
	private String name;
	private String isbn;

	@ManyToOne
	@JoinColumn(name = "autor_id")
	@JsonBackReference
	private AutorEntity autor;

	public BuchEntity() {
		super();
	}

	public BuchEntity(Double preis, String name, String isbn, AutorEntity autor) {
		super();
		this.preis = preis;
		this.name = name;
		this.isbn = isbn;
		this.autor = autor;
	}

	/**
	 * Antwortet das Attribut {@link #id}.
	 * @return das Attribut {@link #id}
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Setzt das Attribut {@link #id}.
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Antwortet das Attribut {@link #preis}.
	 * @return das Attribut {@link #preis}
	 */
	public Double getPreis() {
		return this.preis;
	}

	/**
	 * Setzt das Attribut {@link #preis}.
	 * @param preis
	 */
	public void setPreis(Double preis) {
		this.preis = preis;
	}

	/**
	 * Antwortet das Attribut {@link #name}.
	 * @return das Attribut {@link #name}
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Setzt das Attribut {@link #name}.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Antwortet das Attribut {@link #isbn}.
	 * @return das Attribut {@link #isbn}
	 */
	public String getIsbn() {
		return this.isbn;
	}

	/**
	 * Setzt das Attribut {@link #isbn}.
	 * @param isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Antwortet das Attribut {@link #autor}.
	 * @return das Attribut {@link #autor}
	 */
	public AutorEntity getAutor() {
		return this.autor;
	}

	/**
	 * Setzt das Attribut {@link #autor}.
	 * @param autor
	 */
	public void setAutor(AutorEntity autor) {
		this.autor = autor;
	}

}