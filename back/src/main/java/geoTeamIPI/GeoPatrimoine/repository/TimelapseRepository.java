package geoTeamIPI.GeoPatrimoine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import geoTeamIPI.GeoPatrimoine.entity.Timelapse;

@Repository
public interface TimelapseRepository extends JpaRepository<Timelapse, Long> {
	}

