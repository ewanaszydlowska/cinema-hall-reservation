package pl.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.reservation.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	
}
