package pl.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.reservation.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findOneByemail(String email);
}
