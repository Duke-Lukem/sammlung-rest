package de.provinzial.schulung.service.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import de.provinzial.schulung.persistenz.AutorEntity;
import de.provinzial.schulung.service.model.AutorDTO;

@Component
public class AutorMapper {

	private final BuchMapper buchMapper;

	public AutorMapper(BuchMapper buchMapper) {
		this.buchMapper = buchMapper;
	}

	public AutorDTO toDTO(AutorEntity author) {
		return new AutorDTO(author.getId(), author.getName(), author.getBuecher()
				.stream()
				.map(this.buchMapper::toDTO)
				.collect(Collectors.toList()));
	}

	public AutorEntity toEntity(AutorDTO AutorDTO) {
		AutorEntity author = new AutorEntity(AutorDTO.getName());
		author.setId(AutorDTO.getId());
		return author;
	}
}