package de.provinzial.schulung.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.provinzial.schulung.persistenz.AutorEntity;
import de.provinzial.schulung.persistenz.AutorenRepository;

@RestController
@RequestMapping("/autoren")
public class AutorenConroller {

	@Autowired
	private AutorenRepository autorenRepository;

	@GetMapping()
	public List<AutorEntity> getAutoren() {

		List<AutorEntity> buecher = this.autorenRepository.findAll();

		return buecher;
	}

	@GetMapping("/{id}")
	public AutorEntity getAutor(@PathVariable Long id) {

		Optional<AutorEntity> autor = this.autorenRepository.findById(id);

		return autor.get();
	}

	@GetMapping("/{id}/buecher")
	public AutorEntity getAutorBuecher(@PathVariable Long id) {

		Optional<AutorEntity> autor = this.autorenRepository.findById(id);

		return autor.get();
	}

}