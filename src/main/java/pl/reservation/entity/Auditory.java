package pl.reservation.entity;

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
@Table(name = "auditory")
public class Auditory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Integer seatQuantity;
	
	@ManyToOne
	private Cinema cinema;
	
	@OneToMany(mappedBy = "auditory", cascade = CascadeType.ALL)
	private List<Seat> seats;
	
	@OneToMany(mappedBy = "auditory", cascade = CascadeType.ALL)
	private List<Screening> screening;
	
	public Auditory() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSeatQuantity() {
		return seatQuantity;
	}

	public void setSeatQuantity(Integer seatQuantity) {
		this.seatQuantity = seatQuantity;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public List<Screening> getScreening() {
		return screening;
	}

	public void setScreening(List<Screening> screening) {
		this.screening = screening;
	}

}
