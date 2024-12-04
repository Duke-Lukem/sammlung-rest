package de.provinzial.schulung.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.provinzial.schulung.persistenz.AutorEntity;
import de.provinzial.schulung.persistenz.AutorenRepository;
import de.provinzial.schulung.service.mapper.AutorMapper;
import de.provinzial.schulung.service.model.AutorDTO;

@Service
public class AutorService {

	@Autowired
	private AutorenRepository autorenRepository;

	@Autowired
	private AutorMapper autorMapper;

	public List<AutorDTO> getAllAutoren() {
		return this.autorenRepository.findAll().stream().map(this.autorMapper::toDTO).collect(Collectors.toList());
	}

	public Optional<AutorDTO> getAutor(Long id) {
		return this.autorenRepository.findById(id).map(this.autorMapper::toDTO);
	}

	public AutorDTO createAuthor(AutorDTO autorDTO) {
		AutorEntity author = this.autorMapper.toEntity(autorDTO);

		// hier könnte Logik programmiert werden

		author = this.autorenRepository.save(author);
		return this.autorMapper.toDTO(author);
	}
}