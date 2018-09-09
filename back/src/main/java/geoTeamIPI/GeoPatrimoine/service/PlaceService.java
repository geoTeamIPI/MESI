package geoTeamIPI.GeoPatrimoine.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geoTeamIPI.GeoPatrimoine.entity.Place;
import geoTeamIPI.GeoPatrimoine.repository.PlaceRepository;
import geoTeamIPI.GeoPatrimoine.repository.UserRepository;

@Service
public class PlaceService {
	@Autowired
	private PlaceRepository placeRepository;

	@Autowired
	private UserRepository userRepository;

	public Place findById(Long id) {
		return placeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Failed to get a place with the id=" + id + "!!!"));
	}

	// ------------------------------------ COUNT METHODS ------------------------

	public int countAllPlaces() {
		return (int) placeRepository.count();
	}

	public int countAllPlaces(Long idUser) {
		List<Place> result = placeRepository.findByCreator(idUser);
		return result.size();
	}

	// ------------------------------------ LIST METHODS ------------------------

	public List<Place> findAllPlaces() {
		return placeRepository.findAll();
	}

	public List<Place> findAllPlaces(Long idUser) {
		return placeRepository.findByCreator(idUser);
	}

	public List<Place> findAllPlaces(String longitudeSW, String latitudeSW, String longitudeNE, String latitudeNE) {
		return placeRepository.findByLongitudeGreaterThanAndLatitudeGreaterThanAndLongitudeLessThanAndLatitudeLessThan(longitudeSW, latitudeSW,
				longitudeNE, latitudeNE);
	}

	public List<Place> findAllPlaces(Long idUser, String longitudeSW, String latitudeSW, String longitudeNE, String latitudeNE) {
		return placeRepository
				.findByCreatorAndLongitudeGreaterThanAndLatitudeGreaterThanAndLongitudeLessThanAndLatitudeLessThan(idUser,
						longitudeSW,
						latitudeSW, longitudeNE, latitudeNE);
	}

	// ------------------------------------ CRUD METHODS ------------------------

	public Place createPlace(Place place, Long idUser) {
		LocalDate todaysDate = LocalDate.now();
		place.setCreator(idUser);
		place.setDateCreation(todaysDate);
		return placeRepository.save(place);
	}

	public void deletePlace(Place place) {
		placeRepository.delete(place);
	}

	public <T extends Place> T updatePlace(Long id, T place) {
		LocalDate todaysDate = LocalDate.now();
		place.setId(id);
		place.setDateUpdate(todaysDate);
		return placeRepository.save(place);
	}

	// ------------------------------------ SUB METHODS ------------------------

}
