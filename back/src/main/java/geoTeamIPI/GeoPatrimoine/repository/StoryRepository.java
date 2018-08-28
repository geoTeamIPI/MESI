package geoTeamIPI.GeoPatrimoine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import geoTeamIPI.GeoPatrimoine.entity.Place;
import geoTeamIPI.GeoPatrimoine.entity.Story;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {

	List<Story> findByCreatorId(Long idUser);

	List<Story> findByPlaceIn(List<Place> places);

	List<Story> findByCreatorIdAndPlaceIn(Long idUser, List<Place> places);

	List<Story> findByPlaceLongitudeGreaterThanAndPlaceLatitudeGreaterThanAndPlaceLongitudeLessThanAndPlaceLatitudeLessThan(
			String longitudeSW, String latitudeSW, String longitudeNE, String latitudeNE);

	List<Story> findByCreatorIdAndPlaceLongitudeGreaterThanAndPlaceLatitudeGreaterThanAndPlaceLongitudeLessThanAndPlaceLatitudeLessThan(
			Long idUser, String longitudeSW, String latitudeSW, String longitudeNE, String latitudeNE);

	// --------------------------------------------A VERIFIER TOUT CE QUI EST EN
	// DESSOUS

	/**
	 * Story findbyTimelapse(Timelapse timelapse);
	 */

	/**
	 * @Query("Select * from place where longitude< :longitude and latitude<
	 * :latitude") List<Story> findbyLongPlusLatPlus(@Param("longitude") float
	 * longitude, @Param("latitude") float latitude);
	 * 
	 * @Query("Select * from place where longitude> :longitude and latitude>
	 * :latitude") List<Story> findbyLongMoinsLatMoins(@Param("longitude") float
	 * longitude, @Param("latitude") float latitude);
	 * 
	 * @Query("Select * from story where title= ':keyword' or title like %:keyword%
	 * or description like %:keyword% ") List<Story> findbyKeyword(@Param("keyword")
	 * String keyword);
	 */

	/**
	 * Story findByPlace(Place place); ======= Page findAllByCreator(Optional<User>
	 * user, Pageable pageable);
	 * 
	 * /** @Query("Select p from places p where longitude< :longitudeScreen")
	 * List<Story> findByLongPlusLatPlus(@Param("longitudeScreen") String
	 * longitude);
	 */

	/*
	 * @Query("Select p.* from PLACES p where longitude> :longitude and latitude> :latitude"
	 * ) List<Story> findByLongMoinsLatMoins(@Param("longitude") String
	 * longitude, @Param("latitude") String latitude);
	 * 
	 * 
	 * @Query("Select s from STORIES s where title= ':keyword' or title like %:keyword%  or description like %:keyword% "
	 * ) List<Story> findbyKeyword(@Param("keyword") String keyword);
	 */

	// Story findByType(Type type);

	// Story findByDateCreation(LocalDate date_creation);

	// Story findByDateUpdate(LocalDate dateUpdate);

}
