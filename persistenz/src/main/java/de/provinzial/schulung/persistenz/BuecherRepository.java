package de.provinzial.schulung.persistenz;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuecherRepository
		extends JpaRepository<BuchEntity, Long> {

	List<BuchEntity> findByAutorId(Long autorId);
}