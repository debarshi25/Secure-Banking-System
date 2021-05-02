/*package edu.asu.cse545.group5.SBS.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registeredEmployees")
public class RegisteredEmployee implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column (name = "employeeID", nullable = false)
	private String employeeID;

	@Column (name = "mobileNumber", nullable = false)
	private String mobileNumber;
	
	public RegisteredEmployee(String empID, String mobileNum) {
		setEmployeeID(empID);
		setMobileNumber(mobileNum);
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
*/