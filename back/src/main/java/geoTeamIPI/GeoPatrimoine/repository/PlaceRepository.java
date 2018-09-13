package geoTeamIPI.GeoPatrimoine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import geoTeamIPI.GeoPatrimoine.entity.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

	List<Place> findByCreator(Long idUser);

	@Query("select DISTINCT p.id from Place p")
	List<Long> getAllIds();

	List<Place> findByIdIn(List<Long> idPlace);

	List<Place> findByLongitudeAndLatitude(String longitude, String latitude);

	List<Place> findByLongitudeGreaterThanAndLatitudeGreaterThanAndLongitudeLessThanAndLatitudeLessThan(String longitudeSW, String latitudeSW,
			String longitudeNE, String latitudeNE);

	List<Place> findByCreatorAndLongitudeGreaterThanAndLatitudeGreaterThanAndLongitudeLessThanAndLatitudeLessThan(
			Long idUser, String longitudeSW,
			String latitudeSW, String longitudeNE, String latitudeNE);
}
