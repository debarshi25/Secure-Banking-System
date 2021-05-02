package edu.asu.cse545.group5.SBS.model;

import java.io.Serializable;
import java.sql.Date;

public class AppointmentKey implements Serializable {

    private static final long serialVersionUID = 1L;
    private Date date;
    private String timeSlot;

    public AppointmentKey() {
    }

    public AppointmentKey(Date date, String timeSlot) {
        this.date = date;
        this.timeSlot = timeSlot;
    }

    public Date getDate() {
        return date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

}
