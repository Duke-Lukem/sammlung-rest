package de.provinzial.schulung.service.buecher.mapper;

import org.springframework.stereotype.Component;

import de.provinzial.schulung.persistenz.buecher.model.AutorEntity;
import de.provinzial.schulung.persistenz.buecher.model.BuchEntity;
import de.provinzial.schulung.service.buecher.model.BuchDTO;

@Component
public class BuchMapper {

	public BuchDTO toDTO(BuchEntity buch) {
		return new BuchDTO(buch.getId(), buch.getPreis(), buch.getName(), buch.getIsbn(), buch.getAuflage(), buch
				.getErscheinungsjahr(), buch.getAutor().getId());
	}

	public BuchEntity toEntity(BuchDTO buchDTO, AutorEntity autor) {
		BuchEntity book = new BuchEntity(buchDTO.getPreis(), buchDTO.getName(), buchDTO.getIsbn(), buchDTO.getAuflage(), buchDTO
				.getErscheinungsjahr(), autor);
		book.setId(buchDTO.getId());
		return book;
	}
}