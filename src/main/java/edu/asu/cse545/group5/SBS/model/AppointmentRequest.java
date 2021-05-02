package edu.asu.cse545.group5.SBS.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "appointmentRequests")
public class AppointmentRequest implements Serializable {

	private static final long serialVersionUID = 1L;
    
	@Id
	@Column(name="Id", nullable = false) 
	private String Id; 
	
	@Column(name= "username", nullable = false)
	private String username;

	@Column(name = "date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "timeSlot", nullable = false)
	private String timeSlot;

	@Column(name = "requestMessage", nullable = false)
	private String requestMessage;
    
	@Column(name = "status", nullable = false)
	private String status;

	public AppointmentRequest() {
		this.Id = ""; 
		this.username = " ";
		this.date = new Date();
		this.timeSlot = "11 AM";
		this.requestMessage = "";
		this.status = "open";
	}

	public AppointmentRequest(String username, Date date, String timeSlot, String requestMessage) {
		this.username = username;
		this.date = date;
		this.timeSlot = timeSlot;
		this.requestMessage = requestMessage;
		this.status = "open";
	}

	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getRequestMessage() {
		return requestMessage;
	}

	public void setRequestMessage(String requestMessage) {
		this.requestMessage = requestMessage;
	} 

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
        this.status = status;
	}

}
