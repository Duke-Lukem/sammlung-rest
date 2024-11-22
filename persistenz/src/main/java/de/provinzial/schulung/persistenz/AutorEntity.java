package de.provinzial.schulung.persistenz;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class AutorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<BuchEntity> buecher = new HashSet<>();

	public AutorEntity() {
		super();
	}

	public AutorEntity(String name) {
		super();
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

	public Set<BuchEntity> getBuecher() {
		return this.buecher;
	}

	public void setBuecher(Set<BuchEntity> buecher) {
		this.buecher = buecher;
	}

}
