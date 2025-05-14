package de.provinzial.schulung.service.vinyl.model;

public class AlbumDTO {

	private Long id;
	private String title;
	private String releaseDate;
	private Boolean signature;
	private Double purchasePrice;
	private Double currentValue;
	private String coverUrl;
	private Long bandId;

	public AlbumDTO() {
		super();
	}

	public AlbumDTO(Long id, String title, String releaseDate, Boolean signature, Double purchasePrice, Double currentValue,
			String coverUrl, Long bandId) {
		super();
		this.id = id;
		this.title = title;
		this.releaseDate = releaseDate;
		this.signature = signature;
		this.purchasePrice = purchasePrice;
		this.currentValue = currentValue;
		this.coverUrl = coverUrl;
		this.bandId = bandId;
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

	public Long getBandId() {
		return this.bandId;
	}

	public void setBandId(Long bandId) {
		this.bandId = bandId;
	}

}