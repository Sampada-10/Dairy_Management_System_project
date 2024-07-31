package com.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CustomerInfo")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_id",length = 10)
	private int c_id;
	
	@Column(name="c_name",length = 20)
	private String c_name;
	
	@Column(name="c_address",length = 30)
	private String c_address;
	
	@Column(name="c_email",length = 20)
	private String c_email;
	
	@OneToOne
	private List <Transaction> trans;
	
	public Customer() {
		super();
		
	}

	public int getC_id() {
		return c_id;
	}

	public Customer(String c_name, String c_address, String c_email) {
		super();
		this.c_name = c_name;
		this.c_address = c_address;
		this.c_email = c_email;
	}

	@Override
	public String toString() {
		return "Customer [c_id=" + c_id + ", c_name=" + c_name + ", c_address=" + c_address + ", c_email=" + c_email
				+ "]";
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_address() {
		return c_address;
	}

	public void setC_address(String c_address) {
		this.c_address = c_address;
	}

	public String getC_email() {
		return c_email;
	}

	public void setC_email(String c_email) {
		this.c_email = c_email;
	}

	
}
