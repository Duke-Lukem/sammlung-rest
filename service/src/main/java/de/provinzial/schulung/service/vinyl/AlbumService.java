package de.provinzial.schulung.service.vinyl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.provinzial.schulung.persistenz.vinyl.model.AlbumEntity;
import de.provinzial.schulung.persistenz.vinyl.model.BandEntity;
import de.provinzial.schulung.persistenz.vinyl.repos.AlbumRepository;
import de.provinzial.schulung.persistenz.vinyl.repos.BandRepository;
import de.provinzial.schulung.service.vinyl.mapper.AlbumMapper;
import de.provinzial.schulung.service.vinyl.model.AlbumDTO;

@Service
public class AlbumService {

	@Autowired
	private AlbumRepository albumRepository;

	@Autowired
	private BandRepository bandRepository;

	@Autowired
	private AlbumMapper albumMapper;

	public List<AlbumDTO> getAllAlbum() {
		List<AlbumDTO> alben = this.albumRepository.findAll().stream().map(this.albumMapper::toDTO).collect(Collectors.toList());

		return alben;
	}

	public Optional<AlbumDTO> getAlbum(Long id) {
		return this.albumRepository.findById(id).map(this.albumMapper::toDTO);
	}

	public List<AlbumDTO> getAlbumVonBand(Long id) {
		return this.albumRepository.findByBandId(id).stream().map(this.albumMapper::toDTO).collect(Collectors.toList());
	}

	public AlbumDTO createAlbum(AlbumDTO albumDTO) {
		BandEntity band = this.bandRepository.findById(albumDTO.getBandId())
				.orElseThrow(() -> new RuntimeException("Autor not found"));

		AlbumEntity album = this.albumMapper.toEntity(albumDTO, band);

		// hier könnte Logik programmiert werden

		album = this.albumRepository.save(album);
		return this.albumMapper.toDTO(album);
	}

	public boolean deleteAlbum(Long id) {
		this.albumRepository.deleteById(id);
		return true;
	}
}