package de.provinzial.schulung.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.provinzial.schulung.persistenz.AutorEntity;
import de.provinzial.schulung.persistenz.AutorenRepository;
import de.provinzial.schulung.persistenz.BuchEntity;
import de.provinzial.schulung.persistenz.BuecherRepository;
import de.provinzial.schulung.service.mapper.BuchMapper;
import de.provinzial.schulung.service.model.BuchDTO;

@Service
public class BuchService {

	@Autowired
	private BuecherRepository buecherRepository;

	@Autowired
	private AutorenRepository autorRepository;

	@Autowired
	private BuchMapper buchMapper;

	public List<BuchDTO> getAllBuecher() {
		return this.buecherRepository.findAll().stream().map(this.buchMapper::toDTO).collect(Collectors.toList());
	}

	public Optional<BuchDTO> getBuch(Long id) {
		return this.buecherRepository.findById(id).map(this.buchMapper::toDTO);
	}

	public List<BuchDTO> getBuecherVonAutor(Long id) {
		return this.buecherRepository.findByAutorId(id).stream().map(this.buchMapper::toDTO).collect(Collectors.toList());
	}

	public BuchDTO createBuch(BuchDTO buchDTO) {
		AutorEntity author = this.autorRepository.findById(buchDTO.getAutorId())
				.orElseThrow(() -> new RuntimeException("Autor not found"));

		BuchEntity book = this.buchMapper.toEntity(buchDTO, author);

		// hier könnte Logik programmiert werden

		book = this.buecherRepository.save(book);
		return this.buchMapper.toDTO(book);
	}
}