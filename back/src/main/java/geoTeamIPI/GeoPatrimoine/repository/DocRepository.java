package geoTeamIPI.GeoPatrimoine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import geoTeamIPI.GeoPatrimoine.entity.Doc;

@Repository
public interface DocRepository extends JpaRepository<Doc, Long> {
	}

