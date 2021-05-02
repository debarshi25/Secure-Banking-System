package edu.asu.cse545.group5.SBS.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "appointmentSlots")
@IdClass(AppointmentKey.class)
public class AppointmentSlot implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column (name = "date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;

	@Id
	@Column (name = "timeSlot", nullable = false)
	private String timeSlot;

	@Column (name = "numAvailableAppointments", nullable = false)
	private int numAvailableAppts;

	public AppointmentSlot() {
	}

	public AppointmentSlot(Date date, String timeSlot, int numAvailableAppts) {
		this.date = date;
		this.timeSlot = timeSlot;
		this.numAvailableAppts = numAvailableAppts;
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
	
	public int getNumAvailableAppts() {
		return numAvailableAppts;
	}
	
	public void setNumAvailableAppts(int numAvailableAppts) {
		this.numAvailableAppts = numAvailableAppts;
	}
}
