package de.provinzial.schulung.persistenz;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BuchEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double preis;
	private String name;

	/**
	 *
	 */
	public BuchEntity() {
		super();
	}

	/**
	 * @param id
	 * @param preis
	 * @param name
	 */
	public BuchEntity(Double preis, String name) {
		super();
		this.preis = preis;
		this.name = name;
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

}