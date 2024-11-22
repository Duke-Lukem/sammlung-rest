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

	@ManyToOne
	@JoinColumn(name = "autor_id")
	@JsonBackReference
	private AutorEntity autor;

	public BuchEntity() {
		super();
	}

	public BuchEntity(Double preis, String name, AutorEntity autor) {
		super();
		this.preis = preis;
		this.name = name;
		this.autor = autor;
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

	public AutorEntity getAutor() {
		return this.autor;
	}

	public void setAutor(AutorEntity autor) {
		this.autor = autor;
	}

}