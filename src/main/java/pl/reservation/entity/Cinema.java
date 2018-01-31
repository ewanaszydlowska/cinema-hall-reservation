package pl.reservation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import pl.reservation.validator.PhoneNumber;

@Entity
@Table(name = "cinema")
public class Cinema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;

	@NotBlank
	private String address;

	@NotBlank
	private String email;

	@NotBlank
	@PhoneNumber
	private String phone;
	
	@OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
	private List<Auditory> auditories;

	public Cinema() {
		super();
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Auditory> getAuditories() {
		return auditories;
	}

	public void setAuditories(List<Auditory> auditories) {
		this.auditories = auditories;
	}

}
