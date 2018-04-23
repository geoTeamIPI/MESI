package geoTeamIPI.GeoPatrimoine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geoTeamIPI.GeoPatrimoine.entity.Doc;

import geoTeamIPI.GeoPatrimoine.repository.DocRepository;

@Service
public class DocService {
		@Autowired
		private DocRepository docRepository;
		
		public Doc findById(Long id) {
			return docRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Failed to get a document with the id=" + id +"!!!"));
		}
		
		public Long countAllDocs() {
			return docRepository.count();
		}
			
	}

