package geoTeamIPI.GeoPatrimoine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geoTeamIPI.GeoPatrimoine.entity.Story;

import geoTeamIPI.GeoPatrimoine.repository.StoryRepository;

@Service
public class StoryService {
		@Autowired
		private StoryRepository storyRepository;
		
		public Story findById(Long id) {
			return storyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Failed to get a story with the id=" + id +"!!!"));
		}
		
		public Long countAllStorys() {
			return storyRepository.count();
		}
			
	}

