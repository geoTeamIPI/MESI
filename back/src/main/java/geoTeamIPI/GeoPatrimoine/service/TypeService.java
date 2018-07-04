package geoTeamIPI.GeoPatrimoine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import geoTeamIPI.GeoPatrimoine.entity.Type;
import geoTeamIPI.GeoPatrimoine.repository.TypeRepository;

@Service
public class TypeService {
	@Autowired
	private TypeRepository typeRepository;

	public Long countAllTypes() {
		return typeRepository.count();
	}

	public List<Type> findAllTypes() {
		return typeRepository.findAll();
	}

	public Page<Type> findAllTypes(Integer page, Integer size, String sortProperty, String sortDirection) {
		@SuppressWarnings("deprecation")
		Sort sort = new Sort(new Sort.Order(Sort.Direction.fromString(sortDirection), sortProperty));
		@SuppressWarnings("deprecation")
		Pageable pageable = new PageRequest(page, size, sort);
		return typeRepository.findAll(pageable);
	}

	public Type createType(Type type) {
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
