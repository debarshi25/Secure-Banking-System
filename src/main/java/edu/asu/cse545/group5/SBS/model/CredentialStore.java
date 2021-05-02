package edu.asu.cse545.group5.SBS.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "credentials")

public class CredentialStore implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column (name = "id", nullable = false, updatable = false)
	private String id;
    
    @Column(name="password", nullable=false)
    private String password;

    @Column(name="role",nullable=false)
    private String role;
    
	public CredentialStore() {
		this.id = "";
		this.password = "";
		this.role = "";
	}

    public CredentialStore(String id, String password, String role) {
		this.id = id;
		this.password = password;
		this.role = role;
	}

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
