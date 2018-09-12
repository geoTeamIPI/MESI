package geoTeamIPI.GeoPatrimoine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import geoTeamIPI.GeoPatrimoine.entity.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
	List<Type> findByIsapproved(Boolean value);
}
