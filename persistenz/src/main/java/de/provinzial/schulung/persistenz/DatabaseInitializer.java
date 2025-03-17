package de.provinzial.schulung.persistenz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

//@Component
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
		this.buecherRepository.save(new BuchEntity(Double.valueOf("22.90"), "Harry Potter und der Stein der Weisen", author1));
		this.buecherRepository.save(new BuchEntity(Double.valueOf("24.90"), "Harry Potter und die Kammer des Schreckens",
				author1));
		this.buecherRepository.save(new BuchEntity(Double.valueOf("25.90"), "Das Lied von Eis und Feuer", author2));
		this.buecherRepository.save(new BuchEntity(Double.valueOf("26.90"), "Ein Spiel der Throne", author2));
		this.buecherRepository.save(new BuchEntity(Double.valueOf("27.90"), "Der Herr der Ringe Die Gefährten", author3));
		this.buecherRepository.save(new BuchEntity(Double.valueOf("28.90"), "Der Herr der Ringe Die zwei Türme", author3));
		this.buecherRepository.save(new BuchEntity(Double.valueOf("29.90"), "Mord im Orientexpress", author4));
		this.buecherRepository.save(new BuchEntity(Double.valueOf("30.90"), "The Shining", author5));

	}
}