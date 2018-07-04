package geoTeamIPI.GeoPatrimoine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import geoTeamIPI.GeoPatrimoine.entity.Media;

@Repository
public interface DocRepository extends JpaRepository<Media, Long> {
	}

