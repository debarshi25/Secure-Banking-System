package edu.asu.cse545.group5.SBS.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Request implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "requestID", nullable = false, updatable = false)
	protected String requestID;
	
	@Column (name = "type", nullable = false)
	protected String type;

	@Column (name= "amount", nullable = false, updatable = false)
    protected Double amount; 

	@Column(name= "description", nullable = false, updatable = false)
	protected String description;

	@Column (name = "status", nullable = false)
	protected String status;

	public Request() {
		this.status = "open";
	}
	
	public String getRequestID() {
		return requestID;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
