package pl.reservation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cinema")
public class Cinema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long id;

	private String name;

	private int numberOfAuditories;

	private String address;

	private String email;

	private String phone;

	public Cinema() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public int getNumberOfAuditories() {
		return numberOfAuditories;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumberOfAuditories(int numberOfAuditories) {
		this.numberOfAuditories = numberOfAuditories;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	

	
}
