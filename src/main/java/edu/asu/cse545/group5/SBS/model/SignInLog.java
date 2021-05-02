package edu.asu.cse545.group5.SBS.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "signInLog")
public class SignInLog implements Serializable {
    
    private static final long serialVersionUID = 1L;

	@Id
	@Column (name = "id", nullable = false, updatable = false)
    private UUID id;

	@Column (name = "user", nullable = false, updatable = false)
	private String user;

    @Column (name = "dateTime", nullable = false, updatable = false)
	@Temporal(TemporalType.DATE)
	private Date date;

	public SignInLog() {
        this.id = UUID.randomUUID();
    }

    public SignInLog(String user, Date date) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
