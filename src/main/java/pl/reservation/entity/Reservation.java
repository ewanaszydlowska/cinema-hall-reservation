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
@Table(name = "reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long id;
	
	@ManyToOne
	private Screening screening;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
	private List<SeatReserved> seatsReserved;
	
	private boolean isPaid;
	
	private boolean isActive;
	
	
}
