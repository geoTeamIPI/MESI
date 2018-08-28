package geoTeamIPI.GeoPatrimoine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geoTeamIPI.GeoPatrimoine.entity.Place;
import geoTeamIPI.GeoPatrimoine.repository.PlaceRepository;

@Service
public class PlaceService {
	@Autowired
	private PlaceRepository placeRepository;

	public Place findById(Long id) {
		return placeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Failed to get a place with the id=" + id + "!!!"));
	}

	public Long countAllPlaces() {
		return placeRepository.count();
	}

	public List<Place> findAllPlaces() {
		return placeRepository.findAll();
	}

	public List<Place> findAllPlaces(String longitudeSW, String latitudeSW, String longitudeNE, String latitudeNE) {
		return placeRepository.findByLongitudeGreaterThanAndLatitudeGreaterThanAndLongitudeLessThanAndLatitudeLessThan(longitudeSW, latitudeSW,
				longitudeNE, latitudeNE);
	}

	public Place createPlace(Place place) {
		return placeRepository.save(place);
	}

	public void deletePlace(Place place) {
		placeRepository.delete(place);
	}

	public <T extends Place> T updatePlace(Long id, T place) {
		place.setId(id);
		return placeRepository.save(place);
	}

	/**
	 * A VERIFIER EN DESSOUS ------------------------------------------------------------ *
	 */

}
