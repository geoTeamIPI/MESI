package geoTeamIPI.GeoPatrimoine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import geoTeamIPI.GeoPatrimoine.entity.Timelapse;
import geoTeamIPI.GeoPatrimoine.entity.User;
import geoTeamIPI.GeoPatrimoine.repository.TimelapseRepository;

@Service
public class TimelapseService {
	@Autowired
	private TimelapseRepository timelapseRepository;

	// ------------------------------------ COUNT METHODS ------------------------

	public Long countAllTimelapses() {
		return timelapseRepository.count();
	}

	// ------------------------------------ LIST METHODS ------------------------

	public List<Timelapse> findAllTimelapses() {
		return timelapseRepository.findByIsapproved(true);
	}

	public List<Timelapse> findAllTimelapsesApprove() {
		return timelapseRepository.findByIsapproved(false);
	}

	public Page<Timelapse> findAllTimelapses(Integer page, Integer size, String sortProperty, String sortDirection) {
		@SuppressWarnings("deprecation")
		Sort sort = new Sort(new Sort.Order(Sort.Direction.fromString(sortDirection), sortProperty));
		@SuppressWarnings("deprecation")
		Pageable pageable = new PageRequest(page, size, sort);
		return timelapseRepository.findAll(pageable);
	}

	// ------------------------------------ CRUD METHODS ------------------------

	public Timelapse createTimelapse(Timelapse timelapse, User user) {
		if (user.getProfile().equals("admin")) {
			timelapse.setIsapproved(true);
		} else {
			timelapse.setIsapproved(false);
		}
		return timelapseRepository.save(timelapse);
	}

	public Timelapse findById(Long id) {
		return timelapseRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Failed to get a timelapse with the id=" + id + "!!!"));
	}

	public void deleteTimelapse(Timelapse timelapse) {
		timelapseRepository.delete(timelapse);
	}

	public <T extends Timelapse> T updateTimelapse(Long id, T timelapse) {
		timelapse.setId(id);
		return timelapseRepository.save(timelapse);
	}

}
