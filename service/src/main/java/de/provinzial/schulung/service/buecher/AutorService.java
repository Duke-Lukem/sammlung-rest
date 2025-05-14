package de.provinzial.schulung.service.buecher;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.provinzial.schulung.persistenz.buecher.model.AutorEntity;
import de.provinzial.schulung.persistenz.buecher.repos.AutorenRepository;
import de.provinzial.schulung.service.buecher.mapper.AutorMapper;
import de.provinzial.schulung.service.buecher.model.AutorDTO;

@Service
public class AutorService {

	@Autowired
	private AutorenRepository autorenRepository;

	@Autowired
	private AutorMapper autorMapper;

	public List<AutorDTO> getAllAutoren() {
		//		return autorPersist.stream().map(this.autorMapper::toDTO).collect(Collectors.toList());

		List<AutorDTO> liste = new ArrayList<>();

		List<AutorEntity> autorPersist = this.autorenRepository.findAll();

		autorPersist.forEach(autorE -> {
			AutorDTO dto = this.autorMapper.toDTO(autorE);
			liste.add(dto);
		});

		return liste;

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