package geoTeamIPI.GeoPatrimoine.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import geoTeamIPI.GeoPatrimoine.entity.Story;
import geoTeamIPI.GeoPatrimoine.entity.Type;
import geoTeamIPI.GeoPatrimoine.entity.User;
import geoTeamIPI.GeoPatrimoine.repository.StoryRepository;
import geoTeamIPI.GeoPatrimoine.repository.UserRepository;

@Service
public class StoryService {
	@Autowired
	private StoryRepository storyRepository;

	@Autowired
	private UserRepository userRepository;

	public Long countAllStories() {
		return storyRepository.count();
	}

	public int countAllStoriesOfMyself(Long idUser) {
		Optional<User> user = userRepository.findById(idUser);
		List<Story> result = storyRepository.findByCreator(user);
		return result.size();
	}

	public List<Story> findAllStories() {
		return storyRepository.findAll();
	}

	public Page<Story> findAllStories(Integer page, Integer size, String sortProperty, String sortDirection) {
		@SuppressWarnings("deprecation")
		Sort sort = new Sort(new Sort.Order(Sort.Direction.fromString(sortDirection), sortProperty));
		@SuppressWarnings("deprecation")
		Pageable pageable = new PageRequest(page, size, sort);
		return storyRepository.findAll(pageable);
	}

	public List<Story> findAllStoriesOfUser(User user) {
		return storyRepository.findByCreator(user);
	}

	public Page<Story> findAllStoriesOfUser(User user, Integer page, Integer size, String sortProperty,
			String sortDirection) {
		@SuppressWarnings("deprecation")
		Sort sort = new Sort(new Sort.Order(Sort.Direction.fromString(sortDirection), sortProperty));
		@SuppressWarnings("deprecation")
		Pageable pageable = new PageRequest(page, size, sort);
		return storyRepository.findAllByCreator(user, pageable);
	}

	public List<Story> findAllStoriesOfMyself(Long idUser) {
		Optional<User> user = userRepository.findById(idUser);
		return storyRepository.findByCreator(user);
	}

	public Page<Story> findAllStoriesOfMyself(Long idUser, Integer page, Integer size, String sortProperty,
			String sortDirection) {
		@SuppressWarnings("deprecation")
		Optional<User> connectedUser = userRepository.findById(idUser);
		Sort sort = new Sort(new Sort.Order(Sort.Direction.fromString(sortDirection), sortProperty));
		@SuppressWarnings("deprecation")
		Pageable pageable = new PageRequest(page, size, sort);
		return storyRepository.findAllByCreator(connectedUser, pageable);
	}

	public Story createStory(Story story) {
		LocalDate todaysDate = LocalDate.now();
		story.setDateCreation(todaysDate);
		return storyRepository.save(story);
	}

	public Story createStory(Story story, Long idUser) {
		LocalDate todaysDate = LocalDate.now();
		Optional<User> user = userRepository.findById(idUser);
		story.setCreatorOpt(user);
		story.setDateCreation(todaysDate);
		return storyRepository.save(story);
	}

	public Story findById(Long id) {
		return storyRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Failed to get a story with the id=" + id + "!!!"));
	}

	public void deleteStory(Story story) {
		storyRepository.delete(story);
	}

	public <T extends Story> T updateStory(Long id, T story) {
		story.setId(id);
		return storyRepository.save(story);
	}

	// --------------------------------------------A VERIFIER TOUT CE QUI EST EN
	// DESSOUS

	public List<Story> findByCreator(User creatorUser) {
		return storyRepository.findByCreator(creatorUser);
	}

	/**
	 * public Story findByLongMoinsLatMoins(Place place) { return
	 * storyRepository.findByLongMoinsLatMoins(place.getLongitude(),
	 * place.getLatitude()); }
	 */

	public Story findByType(Type type) {
		return storyRepository.findByType(type);
	}

	public Story findByDateCreation(LocalDate date_creation) {
		return storyRepository.findByDateCreation(date_creation);
	}

	public Story findByDateUpdate(LocalDate dateUpdate) {
		return storyRepository.findByDateUpdate(dateUpdate);
	}

}