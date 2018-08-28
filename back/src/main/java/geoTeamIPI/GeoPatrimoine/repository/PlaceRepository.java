package geoTeamIPI.GeoPatrimoine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import geoTeamIPI.GeoPatrimoine.entity.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

	List<Place> findByLongitudeGreaterThanAndLatitudeGreaterThanAndLongitudeLessThanAndLatitudeLessThan(
			String longitudeSW, String latitudeSW, String longitudeNE, String latitudeNE);

}
