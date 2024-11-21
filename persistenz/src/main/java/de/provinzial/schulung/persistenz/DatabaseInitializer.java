package de.provinzial.schulung.persistenz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer
		implements CommandLineRunner {

	@Autowired
	private BuecherRepository buecherRepository;
	@Autowired
	private AutorenRepository autorenRepository;

	@Override
	public void run(String... args) throws Exception {

		// Autoren einfügen
		AutorEntity author1 = new AutorEntity("J.K. Rowling");
		this.autorenRepository.save(author1);

		AutorEntity author2 = new AutorEntity("George R.R. Martin");
		this.autorenRepository.save(author2);

		AutorEntity author3 = new AutorEntity("J.R.R. Tolkien");
		this.autorenRepository.save(author3);

		AutorEntity author4 = new AutorEntity("Agatha Christie");
		this.autorenRepository.save(author4);

		AutorEntity author5 = new AutorEntity("Stephen King");
		this.autorenRepository.save(author5);

		// Bücher einfügen
		this.buecherRepository.save(new BuchEntity(Double.valueOf("22.90"), "Harry Potter and the Philosopher's Stone", author1));
		this.buecherRepository.save(new BuchEntity(Double.valueOf("22.90"), "Harry Potter and the Chamber of Secrets", author1));
		this.buecherRepository.save(new BuchEntity(Double.valueOf("22.90"), "A Game of Thrones", author2));
		this.buecherRepository.save(new BuchEntity(Double.valueOf("22.90"), "A Clash of Kings", author2));
		this.buecherRepository.save(new BuchEntity(Double.valueOf("22.90"), "The Fellowship of the Ring", author3));
		this.buecherRepository.save(new BuchEntity(Double.valueOf("22.90"), "The Two Towers", author3));
		this.buecherRepository.save(new BuchEntity(Double.valueOf("22.90"), "Murder on the Orient Express", author4));
		this.buecherRepository.save(new BuchEntity(Double.valueOf("22.90"), "The Shining", author5));

	}
}