package geoTeamIPI.GeoPatrimoine.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import geoTeamIPI.GeoPatrimoine.entity.Story;
import geoTeamIPI.GeoPatrimoine.entity.Type;
import geoTeamIPI.GeoPatrimoine.entity.User;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {

	Story findByType(Type type);

	/**
	 * Story findbyTimelapse(Timelapse timelapse);
	 */

	Story findByDateCreation(LocalDate date_creation);

	Story findByDateUpdate(LocalDate dateUpdate);

	List<Story> findByCreator(User user);

	List<Story> findByCreator(Optional<User> user);

	Page findAllByCreator(User user, Pageable pageable);

	Page findAllByCreator(Optional<User> user, Pageable pageable);

	/**
	 * @Query("Select * from place where longitude< :longitude and latitude< :latitude") List<Story> findbyLongPlusLatPlus(@Param("longitude")
	 * float longitude, @Param("latitude") float latitude);
	 * 
	 * @Query("Select * from place where longitude> :longitude and latitude> :latitude") List<Story> findbyLongMoinsLatMoins(@Param("longitude")
	 * float longitude, @Param("latitude") float latitude);
	 * 
	 * @Query("Select * from story where title= ':keyword' or title like %:keyword% or description like %:keyword% ") List<Story>
	 * findbyKeyword(@Param("keyword") String keyword);
	 */

	// --------------------------------------------A VERIFIER TOUT CE QUI EST EN DESSOUS

	/**
	 * Story findByPlace(Place place);
	 * 
	 * Story findByType(Type type);
	 */
}
