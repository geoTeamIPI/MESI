package geoTeamIPI.GeoPatrimoine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import geoTeamIPI.GeoPatrimoine.entity.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
	}

