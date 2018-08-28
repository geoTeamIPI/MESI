package geoTeamIPI.GeoPatrimoine.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geoTeamIPI.GeoPatrimoine.entity.Story;
import geoTeamIPI.GeoPatrimoine.entity.User;
import geoTeamIPI.GeoPatrimoine.repository.StoryRepository;

@Service
public class StoryService {
	@Autowired
	private StoryRepository storyRepository;

	public Story findById(Long id) {
		return storyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Failed to get a story with the id=" + id + "!!!"));
	}

	// ------------------------------------ COUNT METHODS ------------------------

	public Long countAllStories() {
		return storyRepository.count();
	}

	public int countAllStories(Long idUser) {
		List<Story> result = storyRepository.findByCreatorId(idUser);
		return result.size();
	}

	public int countAllStories(String longitudeSW, String latitudeSW, String longitudeNE, String latitudeNE) {
		List<Story> result = storyRepository
				.findByPlaceLongitudeGreaterThanAndPlaceLatitudeGreaterThanAndPlaceLongitudeLessThanAndPlaceLatitudeLessThan(longitudeSW,
						latitudeSW, longitudeNE, latitudeNE);
		return result.size();
	}

	public int countAllStories(Long idUser, String longitudeSW, String latitudeSW, String longitudeNE, String latitudeNE) {
		List<Story> result = storyRepository
				.findByCreatorIdAndPlaceLongitudeGreaterThanAndPlaceLatitudeGreaterThanAndPlaceLongitudeLessThanAndPlaceLatitudeLessThan(idUser,
						longitudeSW,
						latitudeSW, longitudeNE, latitudeNE);
		return result.size();
	}

	public int countAllStories(String longitudeSW, String latitudeSW, String longitudeNE, String latitudeNE, String longitudeUser,
			String latitudeUser, int diameter) {
		List<Story> result = findAllStoriesByDiameter(longitudeSW, latitudeSW, longitudeNE, latitudeNE, longitudeUser, latitudeUser, diameter);
		return result.size();
	}

	public int countAllStories(Long idUser, String longitudeSW, String latitudeSW, String longitudeNE, String latitudeNE, String longitudeUser,
			String latitudeUser, int diameter) {
		List<Story> result = findAllStoriesByDiameter(idUser, longitudeSW, latitudeSW, longitudeNE, latitudeNE, longitudeUser, latitudeUser,
				diameter);
		return result.size();
	}

	// ------------------------------------ LIST METHODS ------------------------

	public List<Story> findAllStories() {
		return storyRepository.findAll();
	}

	public List<Story> findAllStories(Long idUser) {
		return storyRepository.findByCreatorId(idUser);
	}

	public List<Story> findAllStories(String longitudeSW, String latitudeSW, String longitudeNE, String latitudeNE) {
		return storyRepository
				.findByPlaceLongitudeGreaterThanAndPlaceLatitudeGreaterThanAndPlaceLongitudeLessThanAndPlaceLatitudeLessThan(longitudeSW,
						latitudeSW, longitudeNE, latitudeNE);
	}

	public List<Story> findAllStories(Long idUser, String longitudeSW, String latitudeSW, String longitudeNE, String latitudeNE) {
		return storyRepository
				.findByCreatorIdAndPlaceLongitudeGreaterThanAndPlaceLatitudeGreaterThanAndPlaceLongitudeLessThanAndPlaceLatitudeLessThan(idUser,
						longitudeSW,
						latitudeSW, longitudeNE, latitudeNE);
	}

	public List<Story> findAllStoriesByDiameter(String longitudeSW, String latitudeSW, String longitudeNE, String latitudeNE,
			String longitudeUser, String latitudeUser, int diameter) {
		List<Story> stories = storyRepository
				.findByPlaceLongitudeGreaterThanAndPlaceLatitudeGreaterThanAndPlaceLongitudeLessThanAndPlaceLatitudeLessThan(longitudeSW,
						latitudeSW, longitudeNE, latitudeNE);
		stories = filterStoriesByDiameter(stories, longitudeUser, latitudeUser, diameter);
		return stories;
	}

	public List<Story> findAllStoriesByDiameter(Long idUser, String longitudeSW, String latitudeSW, String longitudeNE, String latitudeNE,
			String longitudeUser, String latitudeUser, int diameter) {
		List<Story> stories = storyRepository
				.findByCreatorIdAndPlaceLongitudeGreaterThanAndPlaceLatitudeGreaterThanAndPlaceLongitudeLessThanAndPlaceLatitudeLessThan(idUser,
						longitudeSW,
						latitudeSW, longitudeNE, latitudeNE);
		stories = filterStoriesByDiameter(stories, longitudeUser, latitudeUser, diameter);
		return stories;
	}

	// ------------------------------------ CRUD METHODS ------------------------

	public Story createStory(Story story, User user) {
		LocalDate todaysDate = LocalDate.now();
		story.setCreator(user);
		story.setDateCreation(todaysDate);
		return storyRepository.save(story);
	}

	public void deleteStory(Story story, User user) {
		Long idCreator = story.getCreator().getId();
		Long idConnectedUser = user.getId();
		if (idCreator == idConnectedUser) {
			storyRepository.delete(story);
		} else {
			// throw denied
		}
	}

	public <T extends Story> void updateStory(Long id, Story story, User user) {
		Story storyOriginal = findById(id);
		Long idCreator = storyOriginal.getCreator().getId();
		System.out.println(idCreator);
		Long idConnectedUser = user.getId();
		System.out.println(idConnectedUser);
		story.setId(id);
		if (idCreator == idConnectedUser) {
			story.setCreator(user);
			storyRepository.save(story);
		} else {
			// throw denied
		}
	}

	// ------------------------------------ SUB METHODS ------------------------

	public List<Story> filterStoriesByDiameter(List<Story> stories, String longitudeUser, String latitudeUser, int diameter) {
		for (Story story : stories) {
			double longitudePoint = Double.parseDouble(story.getPlace().getLongitude());
			double latitudePoint = Double.parseDouble(story.getPlace().getLatitude());
			double longitudeUserFloat = Double.parseDouble(longitudeUser);
			double latitudeUserFloat = Double.parseDouble(latitudeUser);
			double a = longitudePoint - longitudeUserFloat;
			double aSquare = Math.pow(a, 2);
			double b = latitudePoint - latitudeUserFloat;
			double bSquare = Math.pow(b, 2);
			double ab = Math.sqrt(bSquare + aSquare);
			double diameterD = Double.valueOf(diameter);
			if (ab > diameterD) {
				stories.remove(story);
			}
		}
		return stories;
	}

	// --------------------------------------------A VERIFIER TOUT CE QUI EST EN DESSOUS

	/**
	 * public Story findByCreatorUser(User creatorUser) { return storyRepository.findBycreatorUser(creatorUser); }
	 */

	/**
	 * public Story findByPlace(Place place) { return storyRepository.findByPlace(place); }
	 * 
	 * public Story findByType(Type type) { return storyRepository.findByType(type); }
	 */

	/**
	 * public Story findByDateCreation(LocalDate date_creation) { return storyRepository.findByDateCreation(date_creation); }
	 */

	/**
	 * public Story findByDateUpdate(LocalDate dateUpdate) { return storyRepository.findByDateUpdate(dateUpdate); }
	 */

}