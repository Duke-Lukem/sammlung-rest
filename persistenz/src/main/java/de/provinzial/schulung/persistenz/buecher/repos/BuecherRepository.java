package de.provinzial.schulung.persistenz.buecher.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.provinzial.schulung.persistenz.buecher.model.BuchEntity;

@Repository
public interface BuecherRepository
		extends JpaRepository<BuchEntity, Long> {

	List<BuchEntity> findByAutorId(Long autorId);
}