package de.provinzial.schulung.service.vinyl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.provinzial.schulung.persistenz.vinyl.model.BandEntity;
import de.provinzial.schulung.persistenz.vinyl.repos.BandRepository;
import de.provinzial.schulung.service.vinyl.mapper.BandMapper;
import de.provinzial.schulung.service.vinyl.model.BandDTO;

@Service
public class BandService {

	@Autowired
	private BandRepository bandRepository;

	@Autowired
	private BandMapper bandMapper;

	public List<BandDTO> getAllBands() {
		//		return autorPersist.stream().map(this.autorMapper::toDTO).collect(Collectors.toList());

		List<BandDTO> liste = new ArrayList<>();

		List<BandEntity> autorPersist = this.bandRepository.findAll();

		autorPersist.forEach(autorE -> {
			BandDTO dto = this.bandMapper.toDTO(autorE);
			liste.add(dto);
		});

		return liste;

	}

	public Optional<BandDTO> getBand(Long id) {
		return this.bandRepository.findById(id).map(this.bandMapper::toDTO);
	}

	public BandDTO createBand(BandDTO autorDTO) {
		BandEntity author = this.bandMapper.toEntity(autorDTO);

		// hier könnte Logik programmiert werden

		author = this.bandRepository.save(author);
		return this.bandMapper.toDTO(author);
	}
}