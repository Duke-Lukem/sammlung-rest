package de.provinzial.schulung.persistenz.vinyl.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AlbumEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	//	@Temporal(TemporalType.DATE)
	private String releaseDate;

	private Boolean signature;

	private Double purchasePrice;

	private Double currentValue;

	private String coverUrl;

	@ManyToOne
	@JoinColumn(name = "band_id")
	private BandEntity band;

	public AlbumEntity() {
		super();
	}

	public AlbumEntity(String title, String releaseDate, Boolean signature, Double purchasePrice, Double currentValue,
			String coverUrl, BandEntity band) {
		super();
		this.title = title;
		this.releaseDate = releaseDate;
		this.signature = signature;
		this.purchasePrice = purchasePrice;
		this.currentValue = currentValue;
		this.coverUrl = coverUrl;
		this.band = band;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Boolean getSignature() {
		return this.signature;
	}

	public void setSignature(Boolean signature) {
		this.signature = signature;
	}

	public Double getPurchasePrice() {
		return this.purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getCurrentValue() {
		return this.currentValue;
	}

	public void setCurrentValue(Double currentValue) {
		this.currentValue = currentValue;
	}

	public String getCoverUrl() {
		return this.coverUrl;
	}

	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}

	public BandEntity getBand() {
		return this.band;
	}

	public void setBand(BandEntity band) {
		this.band = band;
	}

}