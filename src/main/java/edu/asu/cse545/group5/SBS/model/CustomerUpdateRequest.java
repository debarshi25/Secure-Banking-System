package edu.asu.cse545.group5.SBS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customerUpdateRequests")
public class CustomerUpdateRequest {

	@Id
	@Column(name = "Id", nullable = false, updatable = false)
	private String Id;

	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "employeeId", nullable = false)
	private long employeeId;

	@Column (name = "newFirstName")
	private String newFirstName;

	@Column (name = "newMiddleName")
	private String newMiddleName;

	@Column (name = "newLastName")
	private String newLastName;

	@Column (name = "newEmail")
	private String newEmail;

	@Column (name = "newDOB")
	private String newDob;

	@Column (name = "newSSN")
	private char[] newSsn;

	@Column (name = "newStreetAddress")
	private String newStreetAddress;

	@Column (name = "newAddressLine2")
	private String newAddressLine2;

	@Column (name = "newCity")
	private String newCity;

	@Column (name = "newState")
	private String newState;

	@Column (name = "newZip")
	private String newZip;

	@Column (name = "newCountry")
	private String newCountry;

	@Column (name = "newAltPhone")
	private String newAltPhone;

	public CustomerUpdateRequest() {
		this.Id = "";
		this.status = "open";
		this.username = "";
		this.employeeId = 0;
	}

	public CustomerUpdateRequest(String username, long employeeId) {
		this.username = username;
		this.employeeId = employeeId;
		this.status = "open";
	}

	public String getId() {
		return this.Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getEmployeeID() {
		return employeeId;
	}

	public void setEmployeeID(long employeeID) {
		this.employeeId = employeeID;
	}

	public String getNewFirstName() {
		return newFirstName;
	}

	public void setNewFirstName(String newFirstName) {
		this.newFirstName = newFirstName;
	}

	public String getNewMiddleName() {
		return newMiddleName;
	}

	public void setNewMiddleName(String newMiddleName) {
		this.newMiddleName = newMiddleName;
	}

	public String getNewLastName() {
		return newLastName;
	}

	public void setNewLastName(String newLastName) {
		this.newLastName = newLastName;
	}

	public String getNewEmail() {
		return newEmail;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}

	public String getNewDob() {
		return newDob;
	}

	public void setNewDob(String newDob) {
		this.newDob = newDob;
	}

	public char[] getNewSsn() {
		return newSsn;
	}

	public void setNewSsn(char[] newSsn) {
		this.newSsn = newSsn;
	}

	public String getNewStreetAddress() {
		return newStreetAddress;
	}

	public void setNewStreetAddress(String newStreetAddress) {
		this.newStreetAddress = newStreetAddress;
	}

	public String getNewAddressLine2() {
		return newAddressLine2;
	}

	public void setNewAddressLine2(String newAddressLine2) {
		this.newAddressLine2 = newAddressLine2;
	}

	public String getNewCity() {
		return newCity;
	}

	public void setNewCity(String newCity) {
		this.newCity = newCity;
	}

	public String getNewState() {
		return newState;
	}

	public void setNewState(String newState) {
		this.newState = newState;
	}

	public String getNewZip() {
		return newZip;
	}

	public void setNewZip(String newZip) {
		this.newZip = newZip;
	}

	public String getNewCountry() {
		return newCountry;
	}

	public void setNewCountry(String newCountry) {
		this.newCountry = newCountry;
	}

	public String getNewAltPhone() {
		return newAltPhone;
	}

	public void setNewAltPhone(String newAltPhone) {
		this.newAltPhone = newAltPhone;
	}

}
