package de.provinzial.schulung.persistenz;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorenRepository
		extends JpaRepository<AutorEntity, Long> {

}