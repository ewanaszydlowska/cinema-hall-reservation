package pl.reservation.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "screening")
public class Screening {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long id;
	
	private Date startTime;
	
	@ManyToOne
	private Movie movie;
	
	@ManyToOne
	private Auditory auditory;
	
	@OneToMany(mappedBy = "screening", cascade = CascadeType.ALL)
	private List<SeatReserved> seatReserved;
	
	@OneToMany(mappedBy = "screening", cascade = CascadeType.ALL)
	private List<Reservation> reservation;

	public Screening() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Auditory getAuditory() {
		return auditory;
	}

	public void setAuditory(Auditory auditory) {
		this.auditory = auditory;
	}

	public List<SeatReserved> getSeatReserved() {
		return seatReserved;
	}

	public void setSeatReserved(List<SeatReserved> seatReserved) {
		this.seatReserved = seatReserved;
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

}
