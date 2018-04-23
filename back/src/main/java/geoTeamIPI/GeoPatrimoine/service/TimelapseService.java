package geoTeamIPI.GeoPatrimoine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geoTeamIPI.GeoPatrimoine.entity.Timelapse;

import geoTeamIPI.GeoPatrimoine.repository.TimelapseRepository;

@Service
public class TimelapseService {
		@Autowired
		private TimelapseRepository timelapseRepository;
		
		public Timelapse findById(Long id) {
			return timelapseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Failed to get a timelapse with the id=" + id +"!!!"));
		}
		
		public Long countAllTimelapses() {
			return timelapseRepository.count();
		}
			
	}

