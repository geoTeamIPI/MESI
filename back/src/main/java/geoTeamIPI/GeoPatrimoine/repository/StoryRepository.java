package geoTeamIPI.GeoPatrimoine.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import geoTeamIPI.GeoPatrimoine.entity.Place;
import geoTeamIPI.GeoPatrimoine.entity.Story;
import geoTeamIPI.GeoPatrimoine.entity.Type;
import geoTeamIPI.GeoPatrimoine.entity.User;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {

	/**
	Story findBycreatorUser(User creatorUser);
	
	/**
	Story findByPlace(Place place);
	
	Story findByType(Type type);
	*/
	
	Story findByDateCreation(LocalDate date_creation); 
	
	Story findByDateUpdate(LocalDate dateUpdate);
	}

