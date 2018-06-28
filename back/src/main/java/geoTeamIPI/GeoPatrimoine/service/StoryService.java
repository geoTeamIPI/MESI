package geoTeamIPI.GeoPatrimoine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import geoTeamIPI.GeoPatrimoine.entity.Story;

import geoTeamIPI.GeoPatrimoine.repository.StoryRepository;
import org.springframework.data.domain.Sort;

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
		
		/*
	    public Page<Story> findAllStories(Integer page, Integer size, String sortProperty, String sortDirection) {
	        Sort sort = new Sort(new Sort.Order(Sort.Direction.fromString(sortDirection),sortProperty));
	        Pageable pageable = new PageRequest(page,size,sort);
	        return storyRepository.findAll(pageable);
	    }
	    */
			
	}

