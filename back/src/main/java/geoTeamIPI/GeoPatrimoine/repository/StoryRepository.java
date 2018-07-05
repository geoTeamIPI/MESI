package geoTeamIPI.GeoPatrimoine.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import geoTeamIPI.GeoPatrimoine.entity.Story;
import geoTeamIPI.GeoPatrimoine.entity.User;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {

	List<Story> findByCreator(User user);

	List<Story> findByCreator(Optional<User> user);

	// --------------------------------------------A VERIFIER TOUT CE QUI EST EN DESSOUS

	/**
	 * Story findbyTimelapse(Timelapse timelapse);
	 */

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

	/**
	 * Story findByPlace(Place place);
	 * 
	 * Story findByType(Type type);
	 */

	// Story findByType(Type type);

	// Story findByDateCreation(LocalDate date_creation);

	// Story findByDateUpdate(LocalDate dateUpdate);
}
