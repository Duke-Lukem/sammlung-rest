package de.provinzial.schulung.persistenz.buecher.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.provinzial.schulung.persistenz.buecher.model.AutorEntity;

@Repository
public interface AutorenRepository
		extends JpaRepository<AutorEntity, Long> {

}