package edu.asu.cse545.group5.SBS.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column (name = "username", nullable = false)
	private String username;

	@Column (name = "firstName", nullable = false)
	private String firstName;

	@Column (name = "middleName")
	private String middleName;

	@Column (name = "lastName", nullable = false)
	private String lastName;

	@Column (name = "email", nullable = false)
	private String email;

	@Column (name = "dob", nullable = false)
	private String dob;

	@Column (name = "ssn", nullable = false)
	private char[] ssn;

	@Column (name = "streetAddress", nullable = false)
	private String streetAddress;

	@Column (name = "addressLine2")
	private String addressLine2;

	@Column (name = "city", nullable = false)
	private String city;

	@Column (name = "state", nullable = false)
	private String state;

	@Column (name = "zip", nullable = false)
	private String zip;

	@Column (name = "country", nullable = false)
	private String country;

	@Column (name = "mobileNumber", nullable = false)
	private String mobileNumber;

	@Column (name = "altPhone")
	private String altPhone;

	@Column (name = "securityQ1", nullable = false)
	private String securityQ1;

	@Column (name = "securityA1", nullable = false)
	private char[] securityA1;

	@Column (name = "securityQ2", nullable = false)
	private String securityQ2;

	@Column (name = "securityA2", nullable = false)
	private char[] securityA2;

	public Customer() {
		this.firstName = "";
		this.middleName = "";
		this.lastName = "";
		this.email = "";
		this.dob = "";
		this.ssn = new char[0];
		this.streetAddress = "";
		this.addressLine2 = "";
		this.city = "";
		this.state = "";
		this.zip = "";
		this.country = "";
		this.mobileNumber = "";
		this.altPhone = "";
		this.securityQ1 = "";
		this.securityA1 = new char[0];
		this.securityQ2 = "";
		this.securityA2 = new char[0];
	}

	public Customer(String firstName, String middleName, String lastName, String email, String dob, char[] ssn,
			String streetAddress, String addressLine2, String city, String state, String zip, String country, String mobileNumber,
			String altPhone, String securityQ1, char[] securityA1, String securityQ2, char[] securityA2) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		this.ssn = ssn;
		this.streetAddress = streetAddress;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.mobileNumber = mobileNumber;
		this.altPhone = altPhone;
		this.securityQ1 = securityQ1;
		this.securityA1 = securityA1;
		this.securityQ2 = securityQ2;
		this.securityA2 = securityA2;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDob() {
		return dob;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public char[] getSsn() {
		return ssn;
	}
	
	public void setSsn(char[] ssn) {
		this.ssn = ssn;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public String getAddressLine2() {
		return addressLine2;
	}
	
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getAltPhone() {
		return altPhone;
	}
	
	public void setAltPhone(String altPhone) {
		this.altPhone = altPhone;
	}
	
	public String getSecurityQ1() {
		return securityQ1;
	}
	
	public void setSecurityQ1(String securityQ1) {
		this.securityQ1 = securityQ1;
	}
	
	public char[] getSecurityA1() {
		return securityA1;
	}
	
	public void setSecurityA1(char[] securityA1) {
		this.securityA1 = securityA1;
	}
	
	public String getSecurityQ2() {
		return securityQ2;
	}
	
	public void setSecurityQ2(String securityQ2) {
		this.securityQ2 = securityQ2;
	}
	
	public char[] getSecurityA2() {
		return securityA2;
	}
	
	public void setSecurityA2(char[] securityA2) {
		this.securityA2 = securityA2;
	}
	
}
