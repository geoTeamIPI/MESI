package geoTeamIPI.GeoPatrimoine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geoTeamIPI.GeoPatrimoine.entity.Vote;

import geoTeamIPI.GeoPatrimoine.repository.VoteRepository;

@Service
public class VoteService {
		@Autowired
		private VoteRepository voteRepository;
		
		public Vote findById(Long id) {
			return voteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Failed to get a vote with the id=" + id +"!!!"));
		}
		
		public Long countAllVotes() {
			return voteRepository.count();
		}
	}

