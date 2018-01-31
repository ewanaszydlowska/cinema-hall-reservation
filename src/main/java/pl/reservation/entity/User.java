package pl.reservation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.mindrot.jbcrypt.BCrypt;

import pl.reservation.validator.PhoneNumber;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	@PhoneNumber
	private String phone;

	@NotBlank
	@Email
	@Column(unique = true)
	private String email;

	@NotBlank
	private String password;

	@NotNull
	private Integer age;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Review> reviews;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Rating> ratings;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Reservation> reservations;
	
	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	public boolean isPasswordCorrect(String pwd) {
		return BCrypt.checkpw(pwd, this.password);
	}
	
	public Integer getAge() {
		return age;
	}
	
//	public Integer getAge() {							// pobieramy date urodzenia, dostajemy wiek użytkownika
//		LocalDate date = LocalDate.now();
//		int date1 = date.getYear() - this.age;
//		Integer age = new Integer(date1);
//		return age;
//	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
}
