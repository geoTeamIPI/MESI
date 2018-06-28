package geoTeamIPI.GeoPatrimoine.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import geoTeamIPI.GeoPatrimoine.entity.Place;
import geoTeamIPI.GeoPatrimoine.entity.Story;
import geoTeamIPI.GeoPatrimoine.entity.Type;
import geoTeamIPI.GeoPatrimoine.entity.User;
import geoTeamIPI.GeoPatrimoine.repository.StoryRepository;
import org.springframework.data.domain.Sort;

@Service
public class StoryService {
		@Autowired
		private StoryRepository storyRepository;
		
		public Story findById(Long id) {
			return storyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Failed to get a story with the id=" + id +"!!!"));
		}
		
		/**
		public Story findByCreatorUser(User creatorUser) {
			return storyRepository.findBycreatorUser(creatorUser); 
		}
		*/
		
		/**
		public Story findByPlace(Place place) {
			return storyRepository.findByPlace(place); 
		}
		
		public Story findByType(Type type) {
			return storyRepository.findByType(type); 
		}
		*/
		
		public Story findByDateCreation(LocalDate date_creation) {
			return storyRepository.findByDateCreation(date_creation); 
		}
		
		public Story findByDateUpdate(LocalDate dateUpdate) {
			return storyRepository.findByDateUpdate(dateUpdate); 
		}
		
		public Long countAllStorys() {
			return storyRepository.count();
		}
		
		public Page<Story> findAllStories(Integer page, Integer size, String sortProperty, String sortDirection){
	        @SuppressWarnings("deprecation")
			Sort sort = new Sort(new Sort.Order(Sort.Direction.fromString(sortDirection),sortProperty));
	        @SuppressWarnings("deprecation")
			Pageable pageable = new PageRequest(page,size,sort);
			return storyRepository.findAll(pageable); 
		}
		
		public List<Story> findAllStories(){
			return storyRepository.findAll(); 
		}
		
		public Story createStory(Story story) {
			return storyRepository.save(story); 
		} 
		
		public <T extends Story> T updateStory(Long id, T story) {
			story.setId(id);
			return storyRepository.save(story); 
		}
		
		public void deleteStory(Story story) {
			storyRepository.delete(story);
		}
			
	}

