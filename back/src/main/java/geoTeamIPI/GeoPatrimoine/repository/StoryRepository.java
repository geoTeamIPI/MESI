package geoTeamIPI.GeoPatrimoine.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import geoTeamIPI.GeoPatrimoine.entity.Place;
import geoTeamIPI.GeoPatrimoine.entity.Story;
import geoTeamIPI.GeoPatrimoine.entity.Timelapse;
import geoTeamIPI.GeoPatrimoine.entity.Type;
import geoTeamIPI.GeoPatrimoine.entity.User;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {
	
	List<Story> findByUser(User user);
	
	Story findByType(Type type);
	
	Story findbyTimelapse (Timelapse timelapse);
	
	Story findbyDateUpdate (Date date);
	
	List<Story> findbyPlace (Place place);
	
	}

