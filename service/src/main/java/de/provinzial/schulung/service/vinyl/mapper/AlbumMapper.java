package de.provinzial.schulung.service.vinyl.mapper;

import org.springframework.stereotype.Component;

import de.provinzial.schulung.persistenz.vinyl.model.AlbumEntity;
import de.provinzial.schulung.persistenz.vinyl.model.BandEntity;
import de.provinzial.schulung.service.vinyl.model.AlbumDTO;

@Component
public class AlbumMapper {

	public AlbumDTO toDTO(AlbumEntity album) {
		return new AlbumDTO(album.getId(), album.getTitle(), album.getReleaseDate(), album.getSignature(), album
				.getPurchasePrice(), album.getCurrentValue(), album.getCoverUrl(), album.getBand().getId());
	}

	public AlbumEntity toEntity(AlbumDTO albumDTO, BandEntity band) {
		AlbumEntity album = new AlbumEntity(albumDTO.getTitle(), albumDTO.getReleaseDate(), albumDTO.getSignature(), albumDTO
				.getPurchasePrice(), albumDTO.getCurrentValue(), albumDTO.getCoverUrl(), band);
		album.setId(albumDTO.getId());
		return album;
	}

}