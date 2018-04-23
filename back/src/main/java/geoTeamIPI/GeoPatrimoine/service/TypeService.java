package geoTeamIPI.GeoPatrimoine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geoTeamIPI.GeoPatrimoine.entity.Type;

import geoTeamIPI.GeoPatrimoine.repository.TypeRepository;

@Service
public class TypeService {
		@Autowired
		private TypeRepository typeRepository;
		
		public Type findById(Long id) {
			return typeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Failed to get a type with the id=" + id +"!!!"));
		}
		
		public Long countAllTypes() {
			return typeRepository.count();
		}
			
	}

