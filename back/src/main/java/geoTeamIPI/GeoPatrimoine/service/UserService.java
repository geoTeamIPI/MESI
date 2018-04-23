package geoTeamIPI.GeoPatrimoine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geoTeamIPI.GeoPatrimoine.entity.User;

import geoTeamIPI.GeoPatrimoine.repository.UserRepository;

@Service
public class UserService {
		@Autowired
		private UserRepository userRepository;
		
		public User findById(Long id) {
			return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Failed to get an user with the id=" + id +"!!!"));
		}
		
		public Long countAllUsers() {
			return userRepository.count();
		}
			
	}

