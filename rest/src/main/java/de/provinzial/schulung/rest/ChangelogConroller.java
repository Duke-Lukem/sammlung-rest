package de.provinzial.schulung.rest;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import de.provinzial.schulung.service.AutorService;
import de.provinzial.schulung.service.BuchService;
import de.provinzial.schulung.service.model.AutorDTO;
import de.provinzial.schulung.service.model.BuchDTO;

@RestController
@RequestMapping("/changelog")
public class ChangelogConroller {

	@Autowired
	private BuchService buchService;
	@Autowired
	private AutorService autorService;

	@PostMapping("/generate-changelog")
	public ResponseEntity<String> generateChangelog() {

		List<BuchDTO> allBuecher = this.buchService.getAllBuecher();
		List<AutorDTO> allAutoren = this.autorService.getAllAutoren();

		// Logik zur Erstellung des Changelogs
		//		String changelogXml = this.createChangelogXml(allBuecher);
		String changelogXml = this.createNEWChangelog(allBuecher, allAutoren);
		return ResponseEntity.ok(changelogXml);
	}

	private String createNEWChangelog(List<BuchDTO> allBuecher, List<AutorDTO> alleAutoren) {
		try {
			// Initialisierung des Dokumenten-Builders
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// Neues Dokument erstellen
			Document doc = docBuilder.newDocument();

			// Root-Element: databaseChangeLog
			Element rootElement = doc.createElement("databaseChangeLog");
			rootElement.setAttribute("xmlns", "http://www.liquibase.org/xml/ns/dbchangelog");
			rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
			rootElement.setAttribute("xmlns:ext", "http://www.liquibase.org/xml/ns/dbchangelog-ext");
			rootElement.setAttribute("xsi:schemaLocation",
					"http://www.liquibase.org/xml/ns/dbchangelog http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.1.xsd "
							+ "http://www.liquibase.org/xml/ns/dbchangelog-ext http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-ext.xsd");
			doc.appendChild(rootElement);

			// changeSet
			Element changeSet = doc.createElement("changeSet");
			changeSet.setAttribute("author", "W102350");
			changeSet.setAttribute("id", "1.0-generated");
			rootElement.appendChild(changeSet);

			// preConditions
			Element preConditions = doc.createElement("preConditions");
			Element tableExists = doc.createElement("tableExists");
			tableExists.setAttribute("tableName", "BUCH_ENTITY");
			preConditions.appendChild(tableExists);
			changeSet.appendChild(preConditions);

			// sql
			Element sql = doc.createElement("sql");
			sql.setTextContent(getInsertStatements(allBuecher, alleAutoren));
			changeSet.appendChild(sql);

			// comment
			Element comment = doc.createElement("comment");
			comment.setTextContent("Inserted new record in table 'Buch_Entity'");
			changeSet.appendChild(comment);

			// XML schreiben
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Einrücken
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("db.changelog-gen.xml"));
			transformer.transform(source, result);

			System.out.println("Changelog-Datei erfolgreich erstellt.");

			return doc.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String getInsertStatements(List<BuchDTO> alleBuecher, List<AutorDTO> alleAutoren) {
		String inserts = "";

		for (int i = 0; i < alleAutoren.size(); i++) {
			AutorDTO autor = alleAutoren.get(i);

			inserts += String.format("""
					INSERT INTO AUTOR_ENTITY (id, name) VALUES (%s, '%s');

					""", autor.getId(), autor.getName());

		}

		for (BuchDTO buch : alleBuecher) {
			// @formatter:off
			inserts += String.format("""
				    INSERT INTO BUCH_ENTITY (preis, name, auflage, erscheinungsjahr, isbn, autor_id)
				    VALUES (%s, %s, %s, %s, %s, %s);
				    """,
				    buch.getPreis() == null ? "NULL" : String.format("'%s'", buch.getPreis()),
				    buch.getName() == null ? "NULL" : String.format("'%s'", buch.getName()),
				    buch.getAuflage() == null ? "NULL" : String.format("'%s'", buch.getAuflage()),
				    buch.getErscheinungsjahr() == null ? "NULL" : String.format("'%s'", buch.getErscheinungsjahr()),
				    buch.getIsbn() == null ? "NULL" : String.format("'%s'", buch.getIsbn()),
				    buch.getAutorId() == null ? "NULL" : buch.getAutorId().toString()
				);
			// @formatter:on
			System.out.println(inserts);

		}
		return inserts;
	}

}