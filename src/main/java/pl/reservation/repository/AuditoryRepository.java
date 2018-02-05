package pl.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.reservation.entity.Auditory;

public interface AuditoryRepository extends JpaRepository<Auditory, Long> {

	
}
