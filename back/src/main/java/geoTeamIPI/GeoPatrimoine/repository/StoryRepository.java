package geoTeamIPI.GeoPatrimoine.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import geoTeamIPI.GeoPatrimoine.entity.Story;
import geoTeamIPI.GeoPatrimoine.entity.User;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {

	List<Story> findByCreator(User creator);

	Story findByDateCreation(LocalDate date_creation);

	Story findByDateUpdate(LocalDate dateUpdate);

	Page findAllByCreator(User user, Pageable pageable);

	// --------------------------------------------A VERIFIER TOUT CE QUI EST EN DESSOUS

	/**
	 * Story findByPlace(Place place);
	 * 
	 * Story findByType(Type type);
	 */
}
