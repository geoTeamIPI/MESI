package geoTeamIPI.GeoPatrimoine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geoTeamIPI.GeoPatrimoine.entity.Place;

import geoTeamIPI.GeoPatrimoine.repository.PlaceRepository;

@Service
public class PlaceService {
		@Autowired
		private PlaceRepository placeRepository;
		
		public Place findById(Long id) {
			return placeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Failed to get a place with the id=" + id +"!!!"));
		}
		
		public Long countAllPlaces() {
			return placeRepository.count();
		}
			
	}

