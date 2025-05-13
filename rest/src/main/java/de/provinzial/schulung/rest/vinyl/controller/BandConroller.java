package de.provinzial.schulung.rest.vinyl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.provinzial.schulung.service.vinyl.AlbumService;
import de.provinzial.schulung.service.vinyl.BandService;
import de.provinzial.schulung.service.vinyl.model.AlbumDTO;
import de.provinzial.schulung.service.vinyl.model.BandDTO;

@RestController
@RequestMapping("/bands")
public class BandConroller {

	@Autowired
	private BandService bandService;
	@Autowired
	private AlbumService buechService;

	@GetMapping()
	public List<BandDTO> getBands() {

		List<BandDTO> bands = this.bandService.getAllBands();

		return bands;
	}

	@GetMapping("/{id}")
	public BandDTO getBand(@PathVariable Long id) {

		Optional<BandDTO> band = this.bandService.getBand(id);

		return band.get();
	}

	@GetMapping("/{id}/alben")
	public List<AlbumDTO> getBandAlben(@PathVariable Long id) {

		Optional<BandDTO> band = this.bandService.getBand(id);

		List<AlbumDTO> alben = this.buechService.getAlbumVonBand(id);

		return alben;
	}

	@PostMapping()
	public BandDTO createBand(@RequestBody BandDTO band) {
		BandDTO author = this.bandService.createBand(band);
		return author;
	}

}