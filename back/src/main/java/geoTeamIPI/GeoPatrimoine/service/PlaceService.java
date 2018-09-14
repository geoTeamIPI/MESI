package geoTeamIPI.GeoPatrimoine.service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geoTeamIPI.GeoPatrimoine.entity.Place;
import geoTeamIPI.GeoPatrimoine.repository.PlaceRepository;
import geoTeamIPI.GeoPatrimoine.repository.StoryRepository;
import geoTeamIPI.GeoPatrimoine.repository.UserRepository;

@Service
public class PlaceService {
	@Autowired
	private PlaceRepository placeRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StoryRepository storyRepository;

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

	public List<Place> findAllEmptyPlaces() {
		List<Long> storiesIds = storyRepository.getAllIds();
		List<Long> placesIds = placeRepository.getAllIds();
		List<Long> missingsIds = new ArrayList<>();
		for (Long place : placesIds) {
			boolean found = false;
			for (Long story : storiesIds) {
				if (place.equals(story)) {
					found = true;
				}
			}
			if (found == false) {
				missingsIds.add(place);
			}
		}
		return placeRepository.findByIdIn(missingsIds);
	}

	public Long findByCoordinates(String longitude, String latitude) {
		List<Place> places = placeRepository.findByLongitudeAndLatitude(longitude, latitude);
		return places.get(0).getId();
	}

	// ------------------------------------ CRUD METHODS ------------------------

	public Place createPlace(Place place, Long idUser) {
		LocalDate todaysDate = LocalDate.now();
		place.setCreator(idUser);
		place.setDateCreation(todaysDate);
		return placeRepository.save(place);
	}

	public Place createPlace(String longitude, String latitude, Long idUser) {
		LocalDate todaysDate = LocalDate.now();
		Place place = new Place();
		place.setCreator(idUser);
		place.setDateCreation(todaysDate);
		place.setLongitude(longitude);
		place.setLatitude(latitude);
		placeRepository.save(place);
		return place;
	}

	public void deletePlace(Place place) {
		placeRepository.delete(place);
	}

	public <T extends Place> void updatePlace(Long id, T place) {
		LocalDate todaysDate = LocalDate.now();
		place.setCreator((long) 1);
		place.setId(id);
		place.setDateCreation(todaysDate);
		place.setDateUpdate(todaysDate);
		placeRepository.save(place);
	}

	// ------------------------------------ SUB METHODS ------------------------

	public void createGeoJson(List<Place> places) {
		String featureCollection = "{\n\"type\": \"FeatureCollection\", \n\"features\": [ \n";
		String point;

		for (Place place : places) {
			point = "{\"type\":\"Feature\",\"properties\": {\n \"id\": \""
					+ place.getId() + "\",\n \"streetnumber\":\""
					+ place.getNumberstreet() + "\",\n \"street\": \""
					+ place.getStreet() + "\",\n \"zipcode\": \""
					+ place.getZipcode() + "\",\n\"city\": \""
					+ place.getCity() + "\",\n \"icon\":\""
					+ "circle-15" + "\"\n}"
					+ ", \"geometry\": { \"type\": \"Point\", \"coordinates\": ["
					+ place.getLongitude() + ", " + place.getLatitude() + "] } }";
			featureCollection = featureCollection + point + ",\n";
		}
		featureCollection = featureCollection.substring(0, featureCollection.length() - 2);
		featureCollection = featureCollection + "\n ]\n }";

		// try-with-resources statement based on post comment below :)
		String path = System.getProperty("user.dir");
		path = path.replace("\\back", "\\front\\projects\\showcase\\src\\app\\demo\\examples\\");
		System.out.println(path);
		try (
				FileWriter file = new FileWriter(path + "dataplace.geo.json")) {
			file.write(featureCollection);
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + featureCollection);
		} catch (IOException e) {
			// TODO Auto-generated catch block e.printStackTrace(); }
		}

		// output the result
		System.out.println("featureCollection=" + featureCollection.toString());
	}
}
