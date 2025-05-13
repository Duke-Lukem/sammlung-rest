package de.provinzial.schulung.persistenz.vinyl.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.provinzial.schulung.persistenz.vinyl.model.BandEntity;

@Repository
public interface BandRepository
		extends JpaRepository<BandEntity, Long> {

}