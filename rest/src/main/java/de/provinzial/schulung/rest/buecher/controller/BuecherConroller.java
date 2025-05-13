package de.provinzial.schulung.rest.buecher.controller;

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

import de.provinzial.schulung.service.buecher.BuchService;
import de.provinzial.schulung.service.buecher.model.BuchDTO;

@RestController
@RequestMapping("/buecher")
public class BuecherConroller {

	@Autowired
	private BuchService buchService;

	@GetMapping()
	public List<BuchDTO> getAllBooks() {

		List<BuchDTO> buecher = this.buchService.getAllBuecher();

		return buecher;
	}

	@GetMapping("/{id}")
	public BuchDTO getBook(@PathVariable Long id) {

		Optional<BuchDTO> buch = this.buchService.getBuch(id);

		return buch.get();
	}

	@PostMapping(consumes = "application/json")
	public BuchDTO createBuch(@RequestBody BuchDTO buch) {
		return this.buchService.createBuch(buch);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		boolean isRemoved = this.buchService.deleteBuch(id);
		if (!isRemoved) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}

}