package de.provinzial.schulung.persistenz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorenRepository
		extends JpaRepository<AutorEntity, Long> {

}