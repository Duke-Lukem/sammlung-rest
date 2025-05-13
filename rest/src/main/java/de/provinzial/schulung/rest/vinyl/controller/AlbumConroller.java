package de.provinzial.schulung.rest.vinyl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.provinzial.schulung.service.vinyl.AlbumService;
import de.provinzial.schulung.service.vinyl.model.AlbumDTO;

@RestController
@RequestMapping("/alben")
public class AlbumConroller {

	@Autowired
	private AlbumService albumService;

	@GetMapping()
	public List<AlbumDTO> getAllAlben() {

		List<AlbumDTO> buecher = this.albumService.getAllAlbum();

		return buecher;
	}

	@GetMapping("/{id}")
	public AlbumDTO getAlbum(@PathVariable Long id) {

		Optional<AlbumDTO> buch = this.albumService.getAlbum(id);

		return buch.get();
	}

	@PostMapping(consumes = "application/json")
	public AlbumDTO createAlbum(@RequestBody AlbumDTO buch) {
		return this.albumService.createAlbum(buch);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAlbum(@PathVariable Long id) {
		boolean isRemoved = this.albumService.deleteAlbum(id);
		if (!isRemoved) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}

}