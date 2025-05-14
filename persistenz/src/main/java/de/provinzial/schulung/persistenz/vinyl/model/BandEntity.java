package de.provinzial.schulung.persistenz.vinyl.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class BandEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "band", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<AlbumEntity> albums;

	public BandEntity() {
		super();
	}

	public BandEntity(String name) {
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

	public List<AlbumEntity> getAlbums() {
		return this.albums;
	}

	public void setAlbums(List<AlbumEntity> albums) {
		this.albums = albums;
	}

}