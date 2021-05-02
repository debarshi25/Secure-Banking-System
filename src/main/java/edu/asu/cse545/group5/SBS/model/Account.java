package edu.asu.cse545.group5.SBS.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column (name = "accountNum", nullable = false, updatable = false)
	private long accountNum;

	@Column(name = "username")
	private String username;

	@Column (name = "type", nullable = false, updatable = false)
	private String type;

	@Column (name = "debitCardNum")
	private char[] debitCardNum;

	@Column (name = "debitCardPIN")
	private char[] debitPIN;

	@Column (name = "creditCardNum")
	private char[] creditCardNum;
	
	@Column (name = "creditCardPIN")
	private char[] creditPIN;

	public Account() {
		this.username = "";
		this.type = "";
	}

	public Account(String username, String type) {
		this.username = username;
		this.type = type;
	}

	public long getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(long accountNum) {
		this.accountNum = accountNum;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public char[] getDebitCardNum() {
		return debitCardNum;
	}

	public void setDebitCardNum(char[] debitCardNum) {
		this.debitCardNum = debitCardNum;
	}

	public char[] getDebitPIN() {
		return debitPIN;
	}

	public void setDebitPIN(char[] debitPIN) {
		this.debitPIN = debitPIN;
	}

	public char[] getCreditCardNum() {
		return creditCardNum;
	}

	public void setCreditCardNum(char[] creditCardNum) {
		this.creditCardNum = creditCardNum;
	}

	public char[] getCreditPIN() {
		return creditPIN;
	}

	public void setCreditPIN(char[] creditPIN) {
		this.creditPIN = creditPIN;
	}

}
