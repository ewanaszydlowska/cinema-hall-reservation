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
@Table(name = "seat")
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer row;
	
	private Integer numberInRow;
	
	@ManyToOne
	private Auditory auditory;
	
	@OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
	private List<SeatReserved> seatsReserved;
	
	public Seat() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getNumberInRow() {
		return numberInRow;
	}

	public void setNumberInRow(Integer numberInRow) {
		this.numberInRow = numberInRow;
	}

	public Auditory getAuditory() {
		return auditory;
	}

	public void setAuditory(Auditory auditory) {
		this.auditory = auditory;
	}

	public List<SeatReserved> getSeatsReserved() {
		return seatsReserved;
	}

	public void setSeatsReserved(List<SeatReserved> seatsReserved) {
		this.seatsReserved = seatsReserved;
	}

}
