package de.provinzial.schulung.rest.buecher.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.provinzial.schulung.service.buecher.AutorService;
import de.provinzial.schulung.service.buecher.BuchService;
import de.provinzial.schulung.service.buecher.model.AutorDTO;
import de.provinzial.schulung.service.buecher.model.BuchDTO;

@RestController
@RequestMapping("/autoren")
public class AutorenConroller {

	@Autowired
	private AutorService autorService;
	@Autowired
	private BuchService buechService;

	@GetMapping()
	public List<AutorDTO> getAutoren() {

		List<AutorDTO> buecher = this.autorService.getAllAutoren();

		return buecher;
	}

	@GetMapping("/{id}")
	public AutorDTO getAutor(@PathVariable Long id) {

		Optional<AutorDTO> autor = this.autorService.getAutor(id);

		return autor.get();
	}

	@GetMapping("/{id}/buecher")
	public List<BuchDTO> getAutorBuecher(@PathVariable Long id) {

		Optional<AutorDTO> autor = this.autorService.getAutor(id);

		List<BuchDTO> buecher = this.buechService.getBuecherVonAutor(id);

		return buecher;
	}

	@PostMapping()
	public AutorDTO createAutor(@RequestBody AutorDTO autor) {
		AutorDTO author = this.autorService.createAuthor(autor);
		return author;
	}

}