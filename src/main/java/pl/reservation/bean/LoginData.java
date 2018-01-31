package pl.reservation.bean;

import org.springframework.stereotype.Component;

@Component
public class LoginData {

	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	


	
	
	
}
