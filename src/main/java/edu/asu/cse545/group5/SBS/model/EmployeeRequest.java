package edu.asu.cse545.group5.SBS.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeeRequests")
public class EmployeeRequest implements Serializable {

	private static final long serialVersionUID = 1L;
 
	@Id
	@Column(name = "Id", nullable = false, updatable = false)
    private String Id;

	@Column(name = "status", nullable = false)
	private String status;

	@Column (name = "employeeId", nullable = false)
	private long employeeId;

	@Column (name = "requestMessage", nullable = false)
	private String requestMessage;

	public EmployeeRequest(){
		this.Id = "";
		this.status = "open";
		this.employeeId = 0;
		this.requestMessage = "";
	}

	public EmployeeRequest(long employeeId, String requestMessage) {
		this.status = "open";
		this.employeeId = employeeId;
		this.requestMessage = requestMessage;
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

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getRequestMessage() {
		return requestMessage;
	}

	public void setRequestMessage(String requestMessage) {
		this.requestMessage = requestMessage;
	}

}
