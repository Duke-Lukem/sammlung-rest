package de.provinzial.schulung.service.buecher.mapper;

import org.springframework.stereotype.Component;

import de.provinzial.schulung.persistenz.buecher.model.AutorEntity;
import de.provinzial.schulung.service.buecher.model.AutorDTO;

@Component
public class AutorMapper {

	private final BuchMapper buchMapper;

	public AutorMapper(BuchMapper buchMapper) {
		this.buchMapper = buchMapper;
	}

	public AutorDTO toDTO(AutorEntity author) {
		return new AutorDTO(author.getId(), author.getName());
	}

	public AutorEntity toEntity(AutorDTO autorDTO) {
		AutorEntity author = new AutorEntity(autorDTO.getName());
		author.setId(autorDTO.getId());
		return author;
	}
}