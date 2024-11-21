package de.provinzial.schulung.persistenz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer
		implements CommandLineRunner {

	@Autowired
	private BuecherRepository buecherRepository;

	@Override
	public void run(String... args) throws Exception {

		this.buecherRepository.save(new BuchEntity(Double.valueOf("22.90"), "Harry Potter and the Philosopher's Stone"));
		this.buecherRepository.save(new BuchEntity(Double.valueOf("22.90"), "Harry Potter and the Chamber of Secrets"));
		this.buecherRepository.save(new BuchEntity(Double.valueOf("22.90"), "A Game of Thrones"));
		this.buecherRepository.save(new BuchEntity(Double.valueOf("22.90"), "A Clash of Kings"));
		this.buecherRepository.save(new BuchEntity(Double.valueOf("22.90"), "The Fellowship of the Ring"));
		this.buecherRepository.save(new BuchEntity(Double.valueOf("22.90"), "The Two Towers"));
		this.buecherRepository.save(new BuchEntity(Double.valueOf("22.90"), "Murder on the Orient Express"));
		this.buecherRepository.save(new BuchEntity(Double.valueOf("22.90"), "The Shining"));

	}
}