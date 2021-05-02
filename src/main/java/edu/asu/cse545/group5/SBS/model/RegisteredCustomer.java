/*package edu.asu.cse545.group5.SBS.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registeredCustomers")
public class RegisteredCustomer implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column (name = "username", nullable = false)
	private String username;

	@Column (name = "mobileNumber", nullable = false)
	private String mobileNumber;
	
	public RegisteredCustomer(String pUsername, String mobileNum) {
		setUsername(pUsername);
		setMobileNumber(mobileNum);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
*/