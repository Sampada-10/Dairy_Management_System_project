package com.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DairyOwner")
public class DairyOwner {

	@Id
	@Column(name = "email_id")
	private String emailId;

	@Column(name = "password")
	private String password;

	public String getEmailId() {
		return emailId;
	}
	
	@OneToMany
	@Column(name = "Customer")
	private List<Customer> cutms;
	
	@OneToMany
	@Column(name = "Supplier")
	private List<Supplier> suppliers;

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public DairyOwner() {
		super();

	}

	public DairyOwner(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}

	@Override
	public String toString() {
		return "DairyOwner [emailId=" + emailId + ", password=" + password + "]";
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
