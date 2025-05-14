package de.provinzial.schulung.service.vinyl.mapper;

import org.springframework.stereotype.Component;

import de.provinzial.schulung.persistenz.vinyl.model.BandEntity;
import de.provinzial.schulung.service.vinyl.model.BandDTO;

@Component
public class BandMapper {

	public BandDTO toDTO(BandEntity band) {
		return new BandDTO(band.getId(), band.getName());
	}

	public BandEntity toEntity(BandDTO band) {
		BandEntity author = new BandEntity(band.getName());
		author.setId(band.getId());
		return author;
	}
}