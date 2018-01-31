package pl.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.reservation.entity.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {

	
}
