package de.provinzial.schulung.persistenz;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BuecherRepository
		extends JpaRepository<BuchEntity, Long> {

}