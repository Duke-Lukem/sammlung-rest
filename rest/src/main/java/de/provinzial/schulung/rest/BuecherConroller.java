package de.provinzial.schulung.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.provinzial.schulung.persistenz.BuchEntity;
import de.provinzial.schulung.persistenz.BuecherRepository;

@RestController
@RequestMapping("/buecher")
public class BuecherConroller {

	@Autowired
	private BuecherRepository buecherRepository;

	@GetMapping()
	public List<BuchEntity> getAllBooks() {

		List<BuchEntity> buecher = this.buecherRepository.findAll();

		return buecher;
	}

	@GetMapping("/{id}")
	public BuchEntity getBook(@PathVariable Long id) {

		Optional<BuchEntity> buch = this.buecherRepository.findById(id);

		return buch.get();
	}

}