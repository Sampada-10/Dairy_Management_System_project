package com.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Supplier {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="supplier_id",length = 10)
	private int sId;
	
	@Column(name="supplier_name",length = 20)
	private String sName;
	
	@Column(name="supplier_address",length = 30)
	private String sAddress;
	
	@Column(name="supplier_email",length = 20)
	private String sEmail;
	
	@OneToOne
	private List <Transaction> trans;

	public int getsId() {
		return sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsAddress() {
		return sAddress;
	}

	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	

	@Override
	public String toString() {
		return "Supplier [sId=" + sId + ", sName=" + sName + ", sAddress=" + sAddress + ", sEmail=" + sEmail + "]";
	}

	public Supplier(String sName, String sAddress, String sEmail) {
		super();
		this.sName = sName;
		this.sAddress = sAddress;
		this.sEmail = sEmail;
	}

	public Supplier() {
		super();
	}
	
	
}
