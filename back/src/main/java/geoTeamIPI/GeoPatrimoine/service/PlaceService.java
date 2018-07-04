package geoTeamIPI.GeoPatrimoine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import geoTeamIPI.GeoPatrimoine.entity.Place;
import geoTeamIPI.GeoPatrimoine.repository.PlaceRepository;

@Service
public class PlaceService {
	@Autowired
	private PlaceRepository placeRepository;

	public Long countAllPlaces() {
		return placeRepository.count();
	}

	public List<Place> findAllPlaces() {
		return placeRepository.findAll();
	}

	public Page<Place> findAllPlaces(Integer page, Integer size, String sortProperty, String sortDirection) {
		@SuppressWarnings("deprecation")
		Sort sort = new Sort(new Sort.Order(Sort.Direction.fromString(sortDirection), sortProperty));
		@SuppressWarnings("deprecation")
		Pageable pageable = new PageRequest(page, size, sort);
		return placeRepository.findAll(pageable);
	}

	public Place createPlace(Place place) {
		return placeRepository.save(place);
	}

	public Place findById(Long id) {
		return placeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Failed to get a place with the id=" + id + "!!!"));
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
