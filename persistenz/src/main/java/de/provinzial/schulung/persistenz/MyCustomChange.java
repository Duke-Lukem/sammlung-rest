package de.provinzial.schulung.persistenz;

import liquibase.change.custom.CustomTaskChange;
import liquibase.database.Database;
import liquibase.exception.CustomChangeException;
import liquibase.exception.ValidationErrors;
import liquibase.resource.ResourceAccessor;

public class MyCustomChange
		implements CustomTaskChange {

	@Override
	public void execute(Database database) throws CustomChangeException {
		// Hier implementierst du die Logik des Custom Changes
		System.out.println("Executing custom change");
	}

	@Override
	public String getConfirmationMessage() {
		return "Custom change executed successfully!";
	}

	@Override
	public void setUp() {
		// Hier kannst du Setup-Logik für den Change einfügen
	}

	@Override
	public void setFileOpener(ResourceAccessor resourceAccessor) {
		// Falls notwendig, hier den ResourceAccessor verwenden
	}

	@Override
	public ValidationErrors validate(Database database) {
		return null;
	}
}
