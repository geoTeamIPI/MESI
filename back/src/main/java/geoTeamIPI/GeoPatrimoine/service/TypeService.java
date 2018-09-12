package geoTeamIPI.GeoPatrimoine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geoTeamIPI.GeoPatrimoine.entity.Type;
import geoTeamIPI.GeoPatrimoine.entity.User;
import geoTeamIPI.GeoPatrimoine.repository.TypeRepository;

@Service
public class TypeService {
	@Autowired
	private TypeRepository typeRepository;

	// ------------------------------------ COUNT METHODS ------------------------

	public Long countAllTypes() {
		return typeRepository.count();
	}

	// ------------------------------------ LIST METHODS ------------------------

	public List<Type> findAllTypes() {
		return typeRepository.findByIsapproved(true);
	}

	public List<Type> findAllTypesApprove() {
		return typeRepository.findByIsapproved(false);
	}

	// ------------------------------------ CRUD METHODS ------------------------

	public Type createType(Type type, User user) {
		if (user.getProfile().equals("admin")) {
			type.setIsapproved(true);
		} else {
			type.setIsapproved(false);
		}
		return typeRepository.save(type);
	}

	public Type findById(Long id) {
		return typeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Failed to get a type with the id=" + id + "!!!"));
	}

	public void deleteType(Type type) {
		typeRepository.delete(type);
	}

	public <T extends Type> T updateType(Long id, T type) {
		type.setId(id);
		return typeRepository.save(type);
	}

	/**
	 * A VERIFIER EN DESSOUS ------------------------------------------------------------ *
	 */

}
