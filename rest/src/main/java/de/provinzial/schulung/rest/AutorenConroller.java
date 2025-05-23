package de.provinzial.schulung.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.provinzial.schulung.service.AutorService;
import de.provinzial.schulung.service.BuchService;
import de.provinzial.schulung.service.model.AutorDTO;
import de.provinzial.schulung.service.model.BuchDTO;

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
	public AutorDTO createAutor(@RequestBody String name) {
		AutorDTO autorDTO = new AutorDTO(null, name);
		AutorDTO author = this.autorService.createAuthor(autorDTO);
		return author;
	}

}