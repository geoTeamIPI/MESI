package geoTeamIPI.GeoPatrimoine.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import geoTeamIPI.GeoPatrimoine.entity.Story;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {
	  /*
	 Optional<Story> findById(Long id);
	 */
	}

