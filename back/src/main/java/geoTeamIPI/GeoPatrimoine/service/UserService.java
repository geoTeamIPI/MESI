package geoTeamIPI.GeoPatrimoine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
		
		public User findByEmail(String email) {
			return userRepository.findByEmail(email); 
		}
		
		public Long countAllUsers() {
			return userRepository.count();
		}
		
		/*public Page<User> findAllUsers(Integer page, Integer size, String sortProperty, String sortDirection) {
	        Sort sort = Sort.by(new Sort.Order(Sort.Direction.fromString(sortDirection),sortProperty));
	        Pageable pageable = PageRequest.of(page, size, sort); 
			return userRepository.findAll(pageable); 
		}*/
		
		public List<User> findAllUsers(){
			return userRepository.findAll(); 
		}
		
		/*public <T extends User> T createUser(T user) {
			return userRepository.save(user);
		}*/
		
		public User createUser(User user) {
			return userRepository.save(user); 
		}
		
		public <T extends User> T updateUser(Long id, T user) {
			user.setId(id);
			return userRepository.save(user); 
		}
		
		public void deleteUser(User user) {
			userRepository.delete(user);
		}
		
		// Vérifier le mot de passe et le nom d'user
		public User findByEmailAndPassword(String email, String password) {
			return userRepository.findByEmailAndPassword(email, password);
			
		}
	}

