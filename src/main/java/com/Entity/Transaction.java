package com.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="billNo")
	private int billno;

	@Column(name="Amount")
	private int amount;
	
	@Column(name="Date")
	private Date date;
	
	@OneToOne
	private List<Customer> cust;
	
	@OneToOne
	private List<Supplier> supplier;
	
	public int getBillno() {
		return billno;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Customer> getCust() {
		return cust;
	}

	public void setCust(List<Customer> cust) {
		this.cust = cust;
	}

	public List<Supplier> getSupplier() {
		return supplier;
	}

	public void setSupplier(List<Supplier> supplier) {
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "Transaction [billno=" + billno + ", amount=" + amount + ", date=" + date + ", cust=" + cust
				+ ", supplier=" + supplier + "]";
	}
}
