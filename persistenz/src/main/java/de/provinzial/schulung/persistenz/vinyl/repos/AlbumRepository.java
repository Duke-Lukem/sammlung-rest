package de.provinzial.schulung.persistenz.vinyl.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.provinzial.schulung.persistenz.vinyl.model.AlbumEntity;

@Repository
public interface AlbumRepository
		extends JpaRepository<AlbumEntity, Long> {

	List<AlbumEntity> findByBandId(Long bandId);

}