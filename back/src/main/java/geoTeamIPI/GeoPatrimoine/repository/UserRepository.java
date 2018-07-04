package geoTeamIPI.GeoPatrimoine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import geoTeamIPI.GeoPatrimoine.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmailAndPassword(String email, String password);

	User findByEmail(String email);

}
